// This Day In History
// WikipediaScraper class
// This class is designed to scrape Wikipedia pages to find the page image sources

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.XML;

public class WikipediaScraper {

  private PApplet p;
  private String url;

  public WikipediaScraper(PApplet p, String url) {
    this.p = p;
    this.url = url;
  }

  public PImage getPageImage() {
    PImage image = null;

    try {
      String imageURL = getImageURL();
      boolean validImageURL = isValidImageURL(imageURL);

      if (validImageURL) {
        image = p.loadImage(imageURL);
      } else {
        p.println("INVALID IMAGE URL: " + imageURL + "; url: " + url);
      }
      
    } catch (Exception e) {
      p.println(e + ": " + url);
    }

    return image;
  }

  public String getImageURL() {
    boolean validURL = isValidURL(url);
    String imageURL = null;

    if (validURL) {
      XML wikiPage = p.loadXML(url);
      XML body = getBody(wikiPage);
      XML contentDiv = getContentDiv(body);
      XML bodyContentDiv = getBodyContentDiv(contentDiv);
      XML contentTextDiv = getContentTextDiv(bodyContentDiv);
      XML parserOutputDiv = getParserOutputDiv(contentTextDiv);
      XML infoBoxTable = getInfoBoxTable(parserOutputDiv);

      if (infoBoxTable == null) {
        XML rightThumb = getRightThumb(parserOutputDiv);

        if (rightThumb != null) {
          imageURL = getImageURLFromRightThumb(rightThumb);
        } else {
          XML stackDiv = getStackDiv(parserOutputDiv);
          XML stackTableDiv = getStackTableDiv(stackDiv);
          XML stackTable = getInfoBoxTable(stackTableDiv);
          XML[] stackTableRows = getInfoBoxTableRows(stackTable);
          imageURL = getImageURLFromTableRows(stackTableRows);
        }
        
      } else {
        XML[] tableRows = getInfoBoxTableRows(infoBoxTable);
        imageURL = getImageURLFromTableRows(tableRows);

        if (imageURL == null) {
          XML rightThumb = getRightThumb(parserOutputDiv);
          imageURL = getImageURLFromRightThumb(rightThumb);
        }
        
      }
      
    } else {
      p.println("INVALID URL: " + url);
    }

    return imageURL;
  }

  private boolean isValidURL(String url) {
    boolean validURL = true;

    if (url == null) {
      validURL = false;
    } else if (url.equals("")) {
      validURL = false;
    } else {
      String urlBase = url.substring(0, 27); 

      if (!urlBase.equals("https://wikipedia.org/wiki/")) {
        validURL = false;
      }
      
    }

    return validURL;
  }

  private boolean isValidImageURL(String url) {
    boolean validURL = true;

    if (url == null) {
      validURL = false;
    } else if (url.equals("")) {
      validURL = false;
    } else {
      String urlBase = url.substring(0, 39); 

      if (!urlBase.equals("https://upload.wikimedia.org/wikipedia/")) {
        validURL = false;
      }
      
    }

    return validURL;
  }

  private XML getBody(XML wikiPage) {
    XML body = wikiPage.getChild("body");
    return body;
  }

  private XML getContentDiv(XML body) {
    XML[] divs = body.getChildren("div");

    XML contentDiv = null;
    
    for (int i = 0; i < divs.length; i++) {
      String id = divs[i].getString("id");
      
      if (id != null && id.equals("content")) {
        contentDiv = divs[i];
        break;
      }
      
    }
    
    return contentDiv;
  }

  private XML getBodyContentDiv(XML contentDiv) {
    XML[] contentDivs = contentDiv.getChildren("div");
    XML bodyContentDiv = null;
    
    for (int i = 0; i < contentDivs.length; i++) {
      String id = contentDivs[i].getString("id");
      
      if (id != null && id.equals("bodyContent")) {
        bodyContentDiv = contentDivs[i];
        break;
      }
      
    }
    
    return bodyContentDiv;
  }

  private XML getContentTextDiv(XML bodyContentDiv) {
    XML[] bodyContentDivs = bodyContentDiv.getChildren("div");
    XML contentTextDiv = null;

    for (int i = 0; i < bodyContentDivs.length; i++) {
      String id = bodyContentDivs[i].getString("id");
      
      if (id != null && id.equals("mw-content-text")) {
        contentTextDiv = bodyContentDivs[i];
        break;
      }
      
    }

    return contentTextDiv;
  }

  private XML getParserOutputDiv(XML contentTextDiv) {
    XML parserOutputDiv = contentTextDiv.getChild("div");
    return parserOutputDiv;
  }

  private XML getStackDiv(XML parserOutputDiv) {
    XML[] parserOutputDivs = parserOutputDiv.getChildren("div");
    XML stackDiv = null;

    for (int i = 0; i < parserOutputDivs.length; i++) {
      String divClass = parserOutputDivs[i].getString("class");

      if (divClass != null && divClass.equals("mw-stack mobile-float-reset")) {
        stackDiv = parserOutputDivs[i];
        break;
      }
      
    }

    return stackDiv;
  }

  private XML getStackTableDiv(XML stackDiv) {
    XML stackTableDiv = stackDiv.getChild("div");
    return stackTableDiv;
  }

  private XML getInfoBoxTable(XML parserOutputDiv) {
    XML[] parserOutputTables = parserOutputDiv.getChildren("table");    
    XML infoBoxTable = null;

    for (int i = 0; i < parserOutputTables.length; i++) {
      String tableClass = parserOutputTables[i].getString("class");

      if (tableClass != null) {
        
        if (validTableClass(tableClass)) {
          infoBoxTable = parserOutputTables[i];
          break;
        } else if (tableClass.equals("mw-stack mobile-float-reset")) {
          infoBoxTable = getTableFromStackTable(parserOutputTables[i]);
          break;
        }
        
      }
      
    }

    return infoBoxTable;
  }

  private XML[] getInfoBoxTableRows(XML infoBoxTable) {
    XML tableBody = infoBoxTable.getChild("tbody");
    XML[] tableRows = null;

    if (tableBody == null) {
      tableRows = infoBoxTable.getChildren("tr");
    } else {
      tableRows = tableBody.getChildren("tr");
    }

    return tableRows;
  }

  private XML getTableFromStackTable(XML table) {
    XML[] stackTableRows = null;
    XML stackTableBody = table.getChild("tbody");

    if (stackTableBody == null) {
      stackTableRows = table.getChildren("tr");
    } else {
      stackTableRows = stackTableBody.getChildren("tr");
    }

    XML mainTable = stackTableRows[0].getChild("td").getChild("table");
    return mainTable;
  }

  private boolean validTableClass(String className) {
    String[] validClassNames = {"infobox vcard", "infobox biography vcard", "vertical-navbox vcard", 
      "infobox", "infobox vcard plainlist", "infobox bordered vcard", "vertical-navbox"};
    boolean validClass = false;

    for (int i = 0; i < validClassNames.length; i++) {
      
      if (className.equals(validClassNames[i])) {
        validClass = true;
        break;
      }
      
    }

    return validClass;
  }

  private XML getRightThumb(XML parserOutputDiv) {
    XML[] parserOutputDivs = parserOutputDiv.getChildren("div");
    XML rightThumb = null;

    for (int i = 0; i < parserOutputDivs.length; i++) {
      String divClass = parserOutputDivs[i].getString("class");

      if (divClass != null && divClass.equals("thumb tright")) {
        rightThumb = parserOutputDivs[i];
        break;
      }
      
    }

    return rightThumb;
  }



  private String getImageURLFromTableRows(XML[] infoBoxTableRows) {
    String imageURL = null;

    for (int i = 0; i < infoBoxTableRows.length; i++) {
      XML content = infoBoxTableRows[i].getChild("td");
      
      if (content != null) {
        imageURL = getImageURL(content);
        
        if (imageURL != null) {
          break;
        }
        
      }
      
    }

    return imageURL;
  }

  private String getImageURLFromRightThumb(XML rightThumb) {
    String imageURL = null;
    XML innerThumb = rightThumb.getChild("div");
    imageURL = getImageURL(innerThumb);
    return imageURL;
  }

  private String getImageURL(XML linkParent) {

    if (linkParent != null) {
      XML imageLink = linkParent.getChild("a");
      String imageURL = null;

      if (imageLink != null) {
        XML image = imageLink.getChild("img");

        if (image != null) {
          imageURL = image.getString("src");

          if (imageURL == null) {
            imageURL = image.getString("alt src");
          }
          
        }
        
      }

      if (imageURL != null) {
        imageURL = "https:" + imageURL;
      }

      return imageURL;
    } else {
      return null;
    }
    
  }
  
}