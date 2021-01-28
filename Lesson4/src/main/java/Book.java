class Book implements Comparable<Book>{
    private Author author;
    private String title;
    private int pageCount;

    Book(Author author, String title, int pageCount) {
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return "Book{" + author +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}