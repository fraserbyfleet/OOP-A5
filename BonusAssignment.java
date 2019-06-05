////Fraser Byfleet 15078889
////Jordan Grey 16119032
//// 159234 A2P1.h Library Assignment


class Item {

 protected String location;
 protected String status;
 protected String title;
 protected String type;
 protected int daysOverdue;

private
    String callNo;

public

    Item(String Location, String Status, String Title, String Type, int DaysOverdue,
         String CallNo) { 
        this.location = Location;
        this.status = Status;
        this.title = Title;
        this.type = Type; 
        this.daysOverdue = DaysOverdue; 
        this.callNo = CallNo; 
    }
    Item(){}           
    
    
 public   String getStatus(){
        return this.status;
    }
public  int getStatusNo(){
        if(this.status == null)
            return -1;
        if(this.status.equals("AVAILABLE"))
            return 1;
        if(this.status.equals("MISSING"))
            return 2;
        if(this.status.equals("OVERDUE"))
            return 3;
        return 4;
    }
 public int getdaysOverdue(){
        return this.daysOverdue;
    }

 public   void setdaysOverdue(int daysOverdue) {
        this.daysOverdue = daysOverdue;
    }

    final String getcallNo() {
        return this.callNo;
    }
 public   String getType(){
        return this.type;
    }
 public   String getLocation(){
        return this.location;
    }
public     String getTitle(){
        return this.title;
    }

   protected void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public int getFees(){return 0;};


    public String printEmptyRecord(String type){

        String x = "\nLocation: N/A, Title: EMPTY RECORD, Type: ";
        String y = "\nStatus: MISSING, Call Number: N/A, Subject: N/A\n";
        x = x.concat(type);
        x = x.concat(y);
        
        return x;
    }
    public void printDetails(){}

}



class Book extends Item {
private String authors;
private int numPages;

public

    Book(String Location, String Status, String Title, String Type, int DaysOverdue,
         String CallNo, String Authors, int NumPages) {
         super(Location, Status, Title, Type, DaysOverdue,
         CallNo);
         setauthors(Authors);
         setnumPages(NumPages);
    }
    Book(){
        super();
        //Checking to see if status is valid when the copy finalructor is invoked.
    }

   public final int getFees() {
        int fee = getdaysOverdue() * 2;
        return fee;

    }

    final String getauthors() {
        return authors;
    }

    private void setauthors(final String authors) {
        this.authors = authors;
    }

    private  int getnumPages(){
        return numPages;
    }

   private void setnumPages( int numPages) {
        this.numPages = numPages;
    }

   public void printDetails(){
    int status = this.getStatusNo();
    String callNumber = this.getcallNo();
    String bookAuthors = this.getauthors();
    int bookNumPages = this.getnumPages();
    String statusString = this.getStatus();

    switch (status){               
                
                case 1://AVAILIBLE
                {
                    System.out.println("\nLocation: "+location+", Title: "+title+", Type: "+type+"\n"+
                    "Status: "+statusString+", Call Number: "+callNumber+", Author(s): "+bookAuthors+", Number Pages: "+bookNumPages+"\n");
                    break;
                }

                case 2://MISSING
                {
                    System.out.println("\nLocation: "+location+", Title: "+title+", Type: "+type+"\n"+
                    "Status: "+statusString+", Call Number: "+callNumber+", Author(s): "+bookAuthors+", Number Pages: "+bookNumPages+"\n");
                    break;
                }

                case 3://OVERDUE
                { 
                  System.out.println("\nLocation: "+location+", Title: "+title+", Type: "+type+"\n"+
                   "Status: "+statusString+" "+daysOverdue+", Call Number: "+callNumber+", Author(s): "+bookAuthors+", Number Pages: "+bookNumPages+"\n");
                    break;
                }
                
                case 4://OTHER
                {
                   System.out.print("ERROR! Status entered incorrectly!\n\n");
                   System.out.println("\nLocation: "+location+", Title: "+title+", Type: "+type+"\n"+
                   "Status: "+statusString+" "+daysOverdue+", Call Number: "+callNumber+", Author(s): "+bookAuthors+", Number Pages: "+bookNumPages+"\n");
                    break;
                }
                
                case -1://EMPTY OBJECT
                {
                    String temp = printEmptyRecord("Book");    
                    System.out.println(temp);
                    break;
                }
           
            }
    }
       
    
}

class Journal extends Item {
private    String publisher;
private     int frequency;


    public Journal(String Location, String Status, String Title, String Type, int DaysOverdue,
         String CallNo, int Frequency, String Publisher){ 
        super(Location, Status, Title, Type, DaysOverdue,
         CallNo);
                setpublisher(Publisher);
                setfrequency(Frequency);

           }

    Journal(){
        super();
    }
    //functions are final to prevent any possible changes to data members which is ideal for my gettors
    public  int getFees()  {
        int fee = getdaysOverdue() * 3;
        return fee;

    }

    final String getpublisher() {
        return this.publisher;
    }

    private void setpublisher(final String Publisher) {
        this.publisher = Publisher;
    }

     private int getfrequency(){
        return this.frequency;
    }

    private void setfrequency( int Frequency) {
        this.frequency = Frequency;
    }

    public  void printDetails(){
        int status = this.getStatusNo();
        String callNumber = this.getcallNo();
        int journalFrequency = this.getfrequency();
        String journalPublisher = this.getpublisher(); 
        String statusString = this.getStatus();
        switch (status){
                
                case 1:{
                   System.out.println("\nLocation: "+location+", Title: "+title+", Type: "+type+"\n "+
                    "Status: "+statusString+", Call Number: "+callNumber+", Annual Frequency: "+journalFrequency+", Publisher: "+journalPublisher+"\n");
                    break;
                }
                
                case 2:{
                    System.out.println("\nLocation: "+location+", Title: "+title+", Type: "+type+"\n "+
                    "Status: "+statusString+", Call Number: "+callNumber+", Annual Frequency: "+journalFrequency+", Publisher: "+journalPublisher+"\n");
                    break;
                   } 
                
                case 3:{
                  System.out.println("\nLocation: "+location+", Title: "+title+", Type: "+type+"\n "+
                   "Status: "+statusString+" "+daysOverdue+", Call Number: "+callNumber+", Annual Frequency: "+journalFrequency+", Publisher: "+journalPublisher+"\n");
                    break;
                }
                case 4:{
                    System.out.print("ERROR! Status entered incorrectly!\n\n");
                  System.out.println("\nLocation: "+location+", Title: "+title+", Type: "+type+"\n "+
                   "Status: "+statusString+" "+daysOverdue+", Call Number: "+callNumber+", Annual Frequency: "+journalFrequency+", Publisher: "+journalPublisher+"\n");
                    break;
                }
                
                case -1:
                    {
                    String temp = printEmptyRecord("Journal");    
                    System.out.println(temp);
                    break;
                    }
            }
    }


}

class AV extends Item {
private String subject;
  
    public AV(String Location, String Status, String Title, String Type, int DaysOverdue,
         String CallNo, String Subject) { 
        super(Location, Status, Title, Type, DaysOverdue,
         CallNo);
        this.subject = Subject;
    }
     AV(){
        super();
    }
    
public final String getsubject(){
        return subject;
    }

   private void setsubject(final String subject) {
        this.subject = subject;
    }

    public int getFees(){ 
        int fee = getdaysOverdue() * 5;
        return fee;
    }




    public void printDetails(){
        int status = getStatusNo();
        String callNumber = this.getcallNo();
        String statusString = this.getStatus();
        String AVsubject = this.getsubject(); 
        switch (status){
                
                case 1:{
                   System.out.println( "\nLocation: "+location+", Title: "+title+", Type: "+type+"\n"+
                   "Status: "+statusString+", Call Number: "+callNumber+", Subject: "+AVsubject+"\n");
                    break;
                }
                
                case 2:
                 {
                    System.out.println( "\nLocation: "+location+", Title: "+title+", Type: "+type+"\n"+
                   "Status: "+statusString+", Call Number: "+callNumber+", Subject: "+AVsubject+"\n");
                    break;
                }
                
                case 3:
                {
                   System.out.println( "\nLocation: "+location+", Title: "+title+",  Type: "+type+"\n"+
                   "Status: "+statusString+" "+daysOverdue+", Call Number: "+callNumber+", Subject: "+AVsubject+"\n");;
                    break;
                } 
                case 4:
                {
                    System.out.print("ERROR! Status entered incorrectly!\n\n");
                    System.out.println( "\nLocation: "+location+", Title: "+title+",  Type: "+type+"\n"+
                    "Status: "+statusString+", Call Number: "+callNumber+", Subject: "+AVsubject+"\n");
                    break;
                }                
                
                case -1:
                {   
                    String temp = printEmptyRecord("AV");    
                    System.out.println(temp);
                    break;
                }
            }
    }
}


class Main {
    static public void print() {
       System.out.println( "*************************\n");
        System.out.println( "* Fraser Byfleet, 15078889* \n");
        System.out.println( "*Jordan Grey 16119032*\n");
        System.out.println( "* Assignment 2 Part 1  *\n");
        System.out.println( "* Massey Lib Assignment *\n");
        System.out.println( "*************************\n");
    }
    public static void main(String[] args) {
    // Prints "Hello, World" to the terminal window.
    // System.out.println("Hello Fraser");
    
    print();

    int SIZE = 10;
    Item[] items = new Item[SIZE];

    //3 Books: ctr takes location, status, title, type, days overdue, call number, authors and number of pages
    items [0] = new Book("EBOOK", "AVAILABLE", "C++ How to program", "Book", 0, "EBOOK", "Paul Dietel, Harvey Dietel",
             1080);

    items [1] = new Book("Albany Main Collection", "AVAILABLE", "Absolute C++", "Book", 0, "005.133 C sav",
             "Walter Savitch", 975);

    items [2] = new Book("Manawatu Main Collection", "OVERDUE", "Starting out with C++", "Book", 6, "005.133C++ Gad", "Tony Gaddis", 1238);
    //new Book

    //3 Journals: ctr takes location, status, title, type, days overdue, call number, frequency and publisher
    items [3] = new Journal("ONLINE", "AVAILABLE", "Communications of the ACM", "Journal", 0, "INTERNET", 12, "ACM");

    items [4] = new Journal("ONLINE", "AVAILABLE", "Computers in Human Behaviour", "Journal", 0, "INTERNET", 6, "Pergamon Press");

    items [5] = new Journal("ONLINE", "AVAILABLE", "IEEE Transaction on big data", "Journal", 0, "INTERNET", 4, "IEEE");
    //4 AV: ctr takes location, status, title, type, days overdue, call number and subject
    items [6] = new AV();
    items [7] = new AV("Wellington Music", "OVERDUE", "Music is choice", "AV-music", 5, "782.4949292 Tri",
           "DVD - Rock Music");
    // testing the def constructor -- display empty record when printed.
    items [8] = new AV("Manawatu NZ Collection", "AVAILABLE", "Holy smoke", "AV-music", 0, "782.393429 Gin",
           "DVD - Jazz Music");

    items [9] = new AV("Albany Feature Films", "MISSING", "Indiana Jones", "Video-movie", 0, "731.49291 Ind", "DVD - Adventure movie");

    System.out.println("Printing all " + SIZE + " items.");
    for(int i = 0; i<SIZE; i++){
        items[i].printDetails();
    }
    int fees = 0;
    for(int i = 0; i<SIZE; i++){
        fees+=items[i].getFees();

    }
     System.out.println("\nTotal overdue amount so far is: $" + fees);

    items[1].setCallNo("123.707 ADR"); // change the id of one item
    System.out.println("\n\nChanged LibMU[1] call number... Printing again:");
    items[1].printDetails(); // print the modified item


    System.out.println("\nAdditional test to see if ERROR message performed for invalid status when constructor called: \n");
    AV test = new AV("Albany Feature Films", "FAKE STATUS!", "Star Wars 52", "Video-movie", 0, "831.49321 Ind", "DVD - Adventure movie");
    test.printDetails();
    System.out.println("\nAll done! Arrivederci!");


    }

}

