package vttp.batch5.paf.day21.models;

import java.util.Date;

public class Book {
   private String asin;
   private String title;
   private String author;
   private String soldBy;
   private String imgUrl;
   private String productUrl;
   private float stars;
   private int reviews;
   private float price;
   private Date publishedDate;
   private String categoryName;

   public String getAsin() { return asin; }
   public void setAsin(String asin) { this.asin = asin; }

   public String getTitle() { return title; }
   public void setTitle(String title) { this.title = title; }

   public String getAuthor() { return author; }
   public void setAuthor(String author) { this.author = author; }

   public String getSoldBy() { return soldBy; }
   public void setSoldBy(String soldBy) { this.soldBy = soldBy; }

   public String getImgUrl() { return imgUrl; }
   public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

   public String getProductUrl() { return productUrl; }
   public void setProductUrl(String productUrl) { this.productUrl = productUrl; }

   public float getStars() { return stars; }
   public void setStars(float stars) { this.stars = stars; }

   public int getReviews() { return reviews; }
   public void setReviews(int reviews) { this.reviews = reviews; }

   public float getPrice() { return price; }
   public void setPrice(float price) { this.price = price; }

   public Date getPublishedDate() { return publishedDate; }
   public void setPublishedDate(Date publishedDate) { this.publishedDate = publishedDate; }

   public String getCategoryName() { return categoryName; }
   public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

   @Override
   public String toString() {
      return "Book [asin=" + asin + ", title=" + title + "]";
   }



}
