package model;

public class LateHistory {
    
    String title;
    String name;
    String surname;
    String plannedDate;
    
    public LateHistory(String title, String name, String surname, String plannedDate ){
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.plannedDate = plannedDate;
    }

    public LateHistory(){
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getPlannedDate(){
        return plannedDate;
    }
    public void setPlannedDate(String date){
        this.plannedDate = date;
    }
}
