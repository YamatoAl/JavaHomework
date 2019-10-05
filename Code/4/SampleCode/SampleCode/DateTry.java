public class DateTry{
        private String month;
        private int day;
        private int year;   
        public DateTry(String month,int day,int year){
              this.month=month;
              this.day=day;
              this.year=year;
        }

	public boolean equals(DateTry date){
        boolean result=false;
		if(this.month.compareTo(date.month)==0 && this.day==date.day && this.year==date.year) result=true;
        return result;
        }
        
        public String getMonth(){
		return month;
        }

        public int getDay(){
		return day;
        }

        public int getYear(){
		return year;
        }

        public boolean setMonth(String month){
            boolean result=true;
			this.month=month;
            return result;

        }

        public boolean setDay(int day){
            boolean result=true;
			this.day=day;
            return result;
        }

        public boolean setYear(int year){
            boolean result=true;
			this.year=year;
            return result;
        }

        public boolean setDate(String month,int day,int year){
            boolean result=true;
			this.month=month;
            this.day=day;
            this.year=year;
            return result;
        }

        public boolean setDate(int monthInt,int day,int year){
            boolean result=true;
			this.month=monthString(monthInt);
            this.day=day;
            this.year=year;
			result=true;
            return result;
        }

        public boolean setDate(DateTry date){
            boolean result=true;
			this.month=date.getMonth;
            this.day=date.getDay;
            this.year=date.getYear;
			result=true;
            return result;
        }
        
        
        public String monthString(int monthNumber)
        {
            switch (monthNumber)
            {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
             case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                System.out.println("Fatal Error");
                System.exit(0);
                return "Error"; 
            }
        }
}