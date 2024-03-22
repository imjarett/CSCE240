package prog4uiuserintent2querymapper.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private String inputFileName;
    private String section;
    public Reader(String inputFileName, String section) {
        this.inputFileName = inputFileName;
        this.section = section;
    }

    public void processQuery() {
        String response = "";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            //ALL INFO COMMAND HANDLING
            if(section.equals("all information")){
                while ((line = br.readLine()) != null) {
                    response += line + "\n";
                }
                System.out.println(response);
            }

            //RISK FACTORS COMMAND HANDLING
            if(section.equals("risk factors")){
            String startStringRisk = "Item 1A.    RISK FACTORS";
            String endStringRisk = "15";
            String gmStart = " ITEM 1A - Risk Factors";
            String gmEnd = " ITEM 1B - Unresolved Staff Comments";
                while ((line = br.readLine()) != null) {

                    //J&J CASE
                    if (line.equals(startStringRisk)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringRisk)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }
            if(section.equals("general")){
                String startStringGeneral = "Item 1.BUSINESS";
                String endStringGeneral = "    PART II";
                String gmStart = "PART I)";
                String gmEnd = "PART II)";
                    while ((line = br.readLine()) != null) {
    
                        //J&J CASE
                        if (line.equals(startStringGeneral)) {
                            while ((line = br.readLine()) != null && !line.equals(endStringGeneral)) {
                                response += line+"\n";
                            }
                            System.out.println(response);
                            break;
                        }
                        //GENERAL MILLS CASE
                        else if (line.equals(gmStart)) {
                            while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                                response += line+"\n";
                            }
                            System.out.println(response);
                            break;
                        }
                    }
                }
            //PROPERTIES COMMAND CASE
            if(section.equals("properties")){
                String startStringProperties = "Item 2.PROPERTIES";
                String endStringProperties = "Item 3.LEGAL PROCEEDINGS";
                String gmStart = "ITEM 2 - Properties";
                String gmEnd = "ITEM 3 - Legal Proceedings";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringProperties)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringProperties)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

            //LEGAL PROCEEDINGS COMMAND CASE
            if(section.equals("legal proceedings")){
                String startStringLegal = "Item 3.LEGAL PROCEEDINGS";
                String endStringLegal = "Item 4.MINE SAFETY DISCLOSURES";
                String gmStart = "ITEM 3 - Legal Proceedings";
                String gmEnd = "ITEM 4 - Mine Safety Disclosures";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringLegal)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringLegal)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

            //MINE SAFTEY DISCLOSURE COMMAND HANDLING
            if(section.equals("mine safety disclosures")){
                String startStringMine = "Item 4.MINE SAFETY DISCLOSURES";
                String endStringMine = "16";
                String gmStart = "ITEM 4 - Mine Safety Disclosures";
                String gmEnd = "PART II)";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringMine)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringMine)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

            //DIRECTORS/EXECUTIVE OFFICERS COMMAND CASE
            if(section.equals("directors")){
                String startStringExec = "EXECUTIVE OFFICERS OF THE REGISTRANT";
                String endStringExec = "19";
                String gmStart = "INFORMATION ABOUT OUR EXECUTIVE OFFICERS";
                String gmEnd = "WEBSITE ACCESS";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringExec)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringExec)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

            //SUMMARY COMMAND CASE
            if(section.equals("summary")){
                String startStringSum = "Item 1.BUSINESS";
                String endStringSum = "19";
                String gmStart = "PART I)";
                String gmEnd = "PART II)";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringSum)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringSum)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

            //OPERATIONS AND DISCLOSURES COMMAND CASE
            if(section.equals("operations and disclosures")){
                String startStringOD = "    PART II";
                String endStringOD = "    PART III";
                String gmStart = "PART II)";
                String gmEnd = "PART III)";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringOD)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringOD)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

            //FINANCIAL STATEMENTS COMMAND CASE
            if(section.equals("financial statements")){
                String startStringFin = "PART IV ";
                String endStringFin = "The Company hereby agrees to furnish a copy of any such instrument to the SEC upon request.";
                String gmStart = "PART IV)";
                String gmEnd = "96";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringFin)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringFin)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }
            if(section.equals("business")){
                String startStringRisk = "Item 1.BUSINESS";
                String endStringRisk = "Item 1A.    RISK FACTORS";
                String gmStart = "PART I)";
                String gmEnd = " ITEM 1A - Risk Factors";
                    while ((line = br.readLine()) != null) {
    
                        //J&J CASE
                        if (line.equals(startStringRisk)) {
                            while ((line = br.readLine()) != null && !line.equals(endStringRisk)) {
                                response += line+"\n";
                            }
                            System.out.println(response);
                            break;
                        }
                        //GENERAL MILLS CASE
                        else if (line.equals(gmStart)) {
                            while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                                response += line+"\n";
                            }
                            System.out.println(response);
                            break;
                        }
                    }
                }
                if(section.equals("ceo")){
                    String startStringRisk = "Member, Executive Committee; Executive Vice President, Global Corporate Affairs(a)";
                    String endStringRisk = "Peter M. Fasolo, Ph.D.\t\t60\t\t";
                    String gmStart = "CEO";
                    String gmEnd = "END CEO";
                        while ((line = br.readLine()) != null) {
        
                            //J&J CASE
                            if (line.equals(startStringRisk)) {
                                while ((line = br.readLine()) != null && !line.equals(endStringRisk)) {
                                    response += line+"\n";
                                }
                                System.out.println(response);
                                break;
                            }
                            //GENERAL MILLS CASE
                            else if (line.equals(gmStart)) {
                                while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                                    response += line+"\n";
                                }
                                System.out.println(response);
                                break;
                            }
                        }
                    }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
