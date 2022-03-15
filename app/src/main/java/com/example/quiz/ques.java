package com.example.quiz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ques {
    ArrayList<technology> abc()
    {
        ArrayList<technology> list=new ArrayList<>();
        list.add(new technology("1. Which one is the firstsearch engine in internet?","Google","Archie","Altavista","WAIS","Archie"));
        list.add(new technology("2. First computer virus is known as?","Rabbit","Creeper Virus","Elk Cloner","SCA Virus","Creeper Virus"));
        list.add(new technology("3. Firewall in computers is used for?","Security","Data Transaction","Authentication","Monitoring","Security"));
        list.add(new technology("4. Which of the following is not an operating system?","DOS","Mac","C","Linux","C"));
        list.add(new technology("5. Which of the following is not a database managment software?","MySQL","Oracle","Sybase","COBOL","COBOL"));
        list.add(new technology("6. 1024 bit is equal to how many byte?","1 Byte","128 Byte","32 Byte","64 Byte","128 Byte"));
        list.add(new technology("7. Mac Operating System is developed by which company?","IBM","Apple","Microsoft","Samsung","Apple"));
        list.add(new technology("8. Where is headquater of microsft office located?","Texas","New York","California","Washington","Washington"));
        list.add(new technology("9. Which is the first web browser invented in 1990?","Internet Explorer","Mosaic","Mozilla","Nexus","Nexus"));
        list.add(new technology("10. .gif is an extension of?","Image file","Video file","Audio file","Word file","Image file"));

        return list;
    }
}
