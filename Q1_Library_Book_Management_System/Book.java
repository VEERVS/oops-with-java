class Book{
    private String title;
    private String author;
    private double price;
    private String isbn;

    static int bookCount = 0;

    final String libraryName = "Sunrise Public Library";

    public Book(String title, String author, double price, String isbn){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;

        bookCount++;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public double  getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }


}