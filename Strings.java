class Main {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        String result=sb.toString();
        System.out.println("Concatenated String:"+result);
        //Enhanced for loop or StringBuilder for String Iteration
        String str="Hello";
        System.out.println("Individual Characters:");
        for(char c:str.toCharArray()){
            System.out.println(c+"");
        }
        System.out.println();
        String name="Alice";
        int age=30;
        String message=String.format("My name is %s and I'm %d years old.",name,age);
        System.out.println("Formatted Message:"+message);
        //String comparison using equals() method
        String str1="Hello";
        String str2="hello";
        if(str1.equalsIgnoreCase(str2)){
            System.out.println("Strings are equal.");
        }
        else{
            System.out.println("Strings are not equal.");
        }
        //StringBuilder for String Modification
        StringBuilder ModifiedStr=new StringBuilder("Hello World");
        ModifiedStr.append("!");
        ModifiedStr.insert(5,",");
        ModifiedStr.delete(5,7);
        String ModifiedResult=ModifiedStr.toString();
        System.out.println("Modified String:"+ModifiedResult);
        //Remove Leading and Trailing Whitespaces
        String strWithWhitespaces="Hello World";
        String trimmedStr=strWithWhitespaces.trim();
        System.out.println("Trimmed String:"+trimmedStr);
        //Split Strings
        String strToSplit="Java is awesome";
        String[] parts=strToSplit.split(" ");
        System.out.println("Split Strings:");
        for(String part:parts){
            System.out.println(part);
        }
        //Convert String to Upper or Lower Case
        String strToConvert="Hello World";
        String upperCaseStr=strToConvert.toUpperCase();
        String lowerCaseStr=strToConvert.toLowerCase();
        System.out.println("UpperCase String:"+upperCaseStr);
        //Check for Substring Existence
        String strTocheck="Hello World";
        if(strTocheck.contains("World")){
            System.out.println("Substring 'World' exists in the String.");
        }
        else{
            System.out.println("Substring 'World' does not exists in the String.");
        }
        //Convert other Data Types to Strings
        int number=42;
        String strNumber=String.valueOf(number);
        System.out.println("Converted Number to String:"+strNumber);
    }
}