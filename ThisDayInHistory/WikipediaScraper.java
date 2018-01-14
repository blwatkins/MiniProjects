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
      //p.println(imageURL);
      boolean validImageURL = isValidImageURL(imageURL);
      
      if (validImageURL) {
        image = p.loadImage(imageURL); 
      } else {
        p.println("INVALID IMAGE URL: " + url);
      }
    } 
    catch (Exception e) {
      //p.println(e);
      //p.println("    " + url);
      p.println(url);
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
      XML[] tableRows = getInfoBoxTableRows(infoBoxTable);
      imageURL = getImageURLFromTableRows(tableRows);
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

  private XML getInfoBoxTable(XML parserOutputDiv) {
    XML[] parserOutputTables = parserOutputDiv.getChildren("table");
    XML infoBoxTable = null;

    for (int i = 0; i < parserOutputTables.length; i++) {
      String tableClass = parserOutputTables[i].getString("class");

      if (tableClass != null && tableClass.equals("infobox vcard")) {
        infoBoxTable = parserOutputTables[i];
        break;
      }
    }

    return infoBoxTable;
  }

  private XML[] getInfoBoxTableRows(XML infoBoxTable) {
    XML[] tableRows = infoBoxTable.getChildren("tr");
    return tableRows;
  }

  private String getImageURLFromTableRows(XML[] infoBoxTableRows) {
    String imageURL = null;

    for (int i = 0; i < infoBoxTableRows.length; i++) {
      XML content = infoBoxTableRows[i].getChild("td");

      if (content != null) {
        String contentClass = content.getString("class");
        if (contentClass != null && contentClass.equals("photo")) {
          imageURL = infoBoxTableRows[i].getChild("td").getChild("a").getChild("img").getString("src");
        }
      }
    }

    if (imageURL == null) {
      imageURL = infoBoxTableRows[1].getChild("td").getChild("a").getChild("img").getString("src");
    }

    if (imageURL != null) {
      imageURL = "https:" + imageURL;
    }
    
    return imageURL;
  }
  
}