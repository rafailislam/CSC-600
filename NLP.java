*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nlp;

/**
 *
 * @authors: Rafail Islam, S M Rafiuddin Rifat, Jaydev Sarker
 */
import java.lang.Math;
import java.io.File;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.String;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.util.Locale;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class NLP
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        //CREATING FILES
        File yfile=new File("C:\\NLP.txt");
        FileWriter fwriter=new FileWriter(yfile,true);
        BufferedWriter buffer=new BufferedWriter(fwriter);
        PrintWriter pwriter=new PrintWriter(buffer);

        //get input sentence, declaring variables
        Scanner scanner= new Scanner( System.in);

        String noun[]={};
        String pronoun[]={};
        String preposition[]={};
        String adjective[]={};
        String verb[]={};
        String adverb[]={};
        String articles[]={};
        String neg[]={};
        String conjunction[]={};
        String pos[]=new String[20];
        String position[]=new String[20];
        String np[]=new String[20];
        String vp[]=new String[20];
        String ssgui[]=new String[200];
        String verbphrase[][]=new String[20][20];
        String question;
        String potques[]=new String[20];
        int structure[]=new int[20];
        int ss[][]={{1,5,7,4,1},{2,5,5,6},{7,1,5,7,1},{7,1,5,3,7,1},{2,5,7,4,6},{2,5,8,4,3,1},{1,5,5,2,1},{2,5,1,3,1},{1,5,3,7,1},{7,6,3,1,5,4}};
        int lens[]={5,4,5,6,5,6,5,5,5,6};
        int cn=0;
        int a=0;
        int f=0;
        int vv=0;
        int dd[]=new int[20];
        boolean flag=false;
        boolean lexicon=false;
        int b=0;
        Scanner abc;

        boolean status=true;
        while(status)
        {
            String choicestring=JOptionPane.showInputDialog("Which mode do you want to execute??\n1. LEARNING MODE\n2. PRACTICE MODE\n3. EXIT FROM THE PROGRAM\n");
            //System.out.println("Which mode do you want to execute??\n1. LEARNING MODE\n2. PRACTICE MODE\n3. EXIT FROM THE PROGRAM\n");
            //int choice=scanner.nextInt();
            int choice = Integer.parseInt(choicestring);
            switch(choice)
            {
            case 1:
            {
                JOptionPane.showMessageDialog(null,"SECTION ONE :: LEARNING MODE\n(PARSING & PARTS OF SPEECH TAGGING)");
                //System.out.println("SECTION ONE :: LEARNING MODE\n(PARSING & PARTS OF SPEECH TAGGING)");
                //System.out.println("===============================\n=================================");
                String sentence=JOptionPane.showInputDialog("Type a sentence and click OK: ");
                //System.out.println("Type a sentence and press Enter: ");
                //String sentence = scanner.nextLine();
                //sentence = scanner.nextLine();

                //process user sentence
                //pos[]={};
                a=0;
                StringTokenizer tokens= new StringTokenizer(sentence);
                JOptionPane.showMessageDialog(null,"NUMBER OF WORDS: "+tokens.countTokens());
                //System.out.printf("Number of words: %d",tokens.countTokens() );
                //System.out.println();
                //System.out.print("The words are:\n");
                while(tokens.hasMoreTokens())
                {
                    pos[a]=tokens.nextToken();
                    //System.out.println(tokens.nextToken());
                    a++;
                }

                //Sentence structure and Parts of Speech Tagging
                flag=false;
                lexicon=false;
                b=0;

                for(int i=0; i<a; i++)
                {
                    lexicon=false;
                    //System.out.println(pos[i]);
                    for(int j=0; j<noun.length; j++)
                    {
                        if(pos[i].equalsIgnoreCase(noun[j]))
                        {
                            lexicon=true;
                            structure[b]=1;
                            b++;
                            break;
                        }
                    }
                    for(int j=0; j<pronoun.length; j++)
                    {
                        if(pos[i].equalsIgnoreCase(pronoun[j]))
                        {
                            lexicon=true;
                            structure[b]=2;
                            b++;
                            break;
                        }
                    }
                    for(int j=0; j<preposition.length; j++)
                    {
                        if(pos[i].equalsIgnoreCase(preposition[j]))
                        {
                            lexicon=true;
                            structure[b]=3;
                            b++;
                            break;
                        }
                    }
                    for(int j=0; j<adjective.length; j++)
                    {
                        if(pos[i].equalsIgnoreCase(adjective[j]))
                        {
                            lexicon=true;
                            structure[b]=4;
                            b++;
                            break;
                        }
                    }
                    for(int j=0; j<verb.length; j++)
                    {
                        if(pos[i].equalsIgnoreCase(verb[j]))
                        {
                            lexicon=true;
                            structure[b]=5;
                            b++;
                            break;
                        }
                    }
                    for(int j=0; j<adverb.length; j++)
                    {
                        if(pos[i].equalsIgnoreCase(adverb[j]))
                        {
                            lexicon=true;
                            structure[b]=6;
                            b++;
                            break;
                        }
                    }
                    for(int j=0; j<articles.length; j++)
                    {
                        if(pos[i].equalsIgnoreCase(articles[j]))
                        {
                            lexicon=true;
                            structure[b]=7;
                            b++;
                            break;
                        }
                    }
                    for(int j=0; j<neg.length; j++)
                    {
                        if(pos[i].equalsIgnoreCase(neg[j]))
                        {
                            lexicon=true;
                            structure[b]=8;
                            b++;
                            break;
                        }
                    }
                    for(int j=0; j<conjunction.length; j++)
                    {
                        if(pos[i].equalsIgnoreCase(conjunction[j]))
                        {
                            lexicon=true;
                            structure[b]=9;
                            b++;
                            break;
                        }
                    }
                    String sss="";
                    String nnn="";
                    try
                    {
                        abc=new Scanner(new File("C:\\NLP.txt"));
                        while(abc.hasNext())
                        {
                            sss=abc.next();
                            nnn=abc.next();
                            if(sss.equalsIgnoreCase(pos[i]) && nnn.equalsIgnoreCase("1"))
                            {
                                //System.out.println("FOUND SOMETHING");
                                lexicon=true;
                                structure[b]=1;
                                b++;
                                break;
                            }
                            if(sss.equalsIgnoreCase(pos[i]) && nnn.equalsIgnoreCase("2"))
                            {
                                lexicon=true;
                                structure[b]=2;
                                b++;
                                break;
                            }
                            if(sss.equalsIgnoreCase(pos[i]) && nnn.equalsIgnoreCase("3"))
                            {
                                lexicon=true;
                                structure[b]=3;
                                b++;
                                break;
                            }
                            if(sss.equalsIgnoreCase(pos[i]) && nnn.equalsIgnoreCase("4"))
                            {
                                lexicon=true;
                                structure[b]=4;
                                b++;
                                break;
                            }
                            if(sss.equalsIgnoreCase(pos[i]) && nnn.equalsIgnoreCase("5"))
                            {
                                lexicon=true;
                                structure[b]=5;
                                b++;
                                break;
                            }
                            if(sss.equalsIgnoreCase(pos[i]) && nnn.equalsIgnoreCase("6"))
                            {
                                lexicon=true;
                                structure[b]=6;
                                b++;
                                break;
                            }
                            if(sss.equalsIgnoreCase(pos[i]) && nnn.equalsIgnoreCase("7"))
                            {
                                lexicon=true;
                                structure[b]=7;
                                b++;
                                break;
                            }
                            if(sss.equalsIgnoreCase(pos[i]) && nnn.equalsIgnoreCase("8"))
                            {
                                lexicon=true;
                                structure[b]=8;
                                b++;
                                break;
                            }
                            if(sss.equalsIgnoreCase(pos[i]) && nnn.equalsIgnoreCase("9"))
                            {
                                lexicon=true;
                                structure[b]=9;
                                b++;
                                break;
                            }
                        }
                    }
                    catch(Exception e3)
                    {
                        JOptionPane.showMessageDialog(null,"Could not open file or file does not exist!!\n");
                    }
                    if(lexicon==false)
                    {
                        structure[b]=0;
                        b++;
                        continue;
                    }
                }
                boolean wfound=false;
                String sstructure="";
                //System.out.println(b);
                //System.out.println("The structure of the sentence is: ");
                sstructure="";
                for(int z=0; z<b; z++)
                {
                    if(structure[z]==1)
                    {
                        sstructure=sstructure+"NOUN+";
                        //System.out.print("NOUN+");
                        continue;
                    }
                    if(structure[z]==2)
                    {
                        sstructure=sstructure+"PRONOUN+";
                        //System.out.print("PRONOUN+");
                        continue;
                    }
                    if(structure[z]==3)
                    {
                        sstructure=sstructure+"PREPOSITION+";
                        //System.out.print("PREPOSITION+");
                        continue;
                    }
                    if(structure[z]==4)
                    {
                        sstructure=sstructure+"ADJECTIVE+";
                        //System.out.print("ADJECTIVE+");
                        continue;
                    }
                    if(structure[z]==5)
                    {
                        sstructure=sstructure+"VERB+";
                        //System.out.print("VERB+");
                        continue;
                    }
                    if(structure[z]==6)
                    {
                        sstructure=sstructure+"ADVERB+";
                        //System.out.print("ADVERB+");
                        continue;
                    }
                    if(structure[z]==7)
                    {
                        sstructure=sstructure+"ARTICLE+";
                        //System.out.print("ARTICLE+");
                        continue;
                    }
                    if(structure[z]==8)
                    {
                        sstructure=sstructure+"NEGETIVE+";
                        //System.out.print("NEGETIVE+");
                        continue;
                    }
                    if(structure[z]==9)
                    {
                        sstructure=sstructure+"CONJUNCTION+";
                        //System.out.print("CONJUNCTION+");
                        continue;
                    }
                    wfound=false;
                    if(structure[z]==0)
                    {
                        //yfile.format("%s%d",pos[z],0);
                        //File yfile=new File("C:\\Users\\Copotronic Rifat\\Desktop\\NLP.txt");
                        //FileWriter fwriter=new FileWriter(yfile,true);
                        //BufferedWriter buffer=new BufferedWriter(fwriter);
                        //PrintWriter pwriter=new PrintWriter(buffer);
                        //yfile.println("");
                        if(yfile.exists()==false)
                        {
                            yfile.createNewFile();
                            //System.out.println("The file has been created");
                            JOptionPane.showMessageDialog(null,"The file has been created!!\n");
                        }
                        else
                        {
                            //System.out.println("The file already exists!!");
                            //JOptionPane.showMessageDialog(null,"The file already exists!!\n");
                        }
                        Scanner xyz;
                        String strs="";
                        try
                        {
                            xyz=new Scanner(new File("C:\\NLP.txt"));
                            while(xyz.hasNext())
                            {
                                //if(wfound==true)
                                //{
                                //    continue;
                                //}
                                //wfound=false;
                                strs=xyz.next();
                                String pp=xyz.next();
                                if(strs.equalsIgnoreCase(pos[z]))
                                {
                                    wfound=true;
                                    break;
                                }
                                else
                                {
                                    wfound=false;
                                    continue;
                                }
                            }
                            if(wfound==false)
                            {
                                pwriter.print(pos[z]);
                                JOptionPane.showMessageDialog(null,pos[z]+" added to the lexicon!!\n");
                            }
                        }
                        catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null,"Could not open file or file does not exist!!\n");
                        }


                        for(int str=0; str<10; str++)
                        {
                            int mchcn=0;
                            int newpos=0;
                            int extra=0;
                            for(int mch=0; mch<lens[str]; mch++)
                            {
                                if(structure[mch]==ss[str][mch])
                                {
                                    mchcn++;
                                }
                                else
                                {
                                    extra++;
                                    newpos=ss[str][mch];
                                }
                            }
                            if(mchcn==((lens[str])-1))
                            {
                                if(newpos==1)
                                {
                                    sstructure=sstructure+"NOUN+";
                                    //System.out.print("NOUN+");
                                    pwriter.println(" 1");
                                    //structure[z]=1;
                                }
                                if(newpos==2)
                                {
                                    sstructure=sstructure+"PRONOUN+";
                                    //System.out.print("PRONOUN+");
                                    pwriter.println(" 2");
                                    //structure[z]=2;
                                }
                                if(newpos==3)
                                {
                                    sstructure=sstructure+"PREPOSITION+";
                                    //System.out.print("PREPOSITION+");
                                    pwriter.println(" 3");
                                    //structure[z]=3;
                                }
                                if(newpos==4)
                                {
                                    sstructure=sstructure+"ADJECTIVE+";
                                    //System.out.print("ADJECTIVE+");
                                    pwriter.println(" 4");
                                    //structure[z]=4;
                                }
                                if(newpos==5)
                                {
                                    sstructure=sstructure+"VERB+";
                                    //System.out.print("VERB+");
                                    pwriter.println(" 5");
                                    //structure[z]=5;
                                }
                                if(newpos==6)
                                {
                                    sstructure=sstructure+"ADVERB+";
                                    //System.out.print("ADVERB+");
                                    pwriter.println(" 6");
                                    //structure[z]=6;
                                }
                                if(newpos==7)
                                {
                                    sstructure=sstructure+"ARTICLE+";
                                    //System.out.print("ARTICLE+");
                                    pwriter.println(" 7");
                                    //structure[z]=7;
                                }
                                if(newpos==8)
                                {
                                    sstructure=sstructure+"NEGETIVE+";
                                    //System.out.print("NEGETIVE+");
                                    pwriter.println(" 8");
                                    //structure[z]=8;
                                }
                                if(newpos==9)
                                {
                                    sstructure=sstructure+"CONJUNCTION+";
                                    //System.out.print("CONJUNCTION+");
                                    pwriter.println(" 9");
                                    //structure[z]=9;
                                }
                                //pwriter.close();
                                //break;
                            }
                        }
                    }
                }
                //System.out.println(" ");
                String inputsentence="";
                for(int index=0; index<a; index++)
                {
                    inputsentence=inputsentence+pos[index]+"+";
                }
                JOptionPane.showMessageDialog(null,"The structure of the sentence is: \n"+inputsentence+"\n"+sstructure);
                pwriter.close();
                //System.out.println();
                break;
            }
            case 2:
            {
                //PRACTICE MODE
                JOptionPane.showMessageDialog(null,"SECTION TWO:: PRACTICE MODE\n(QUESTION AND ANSWER)");
                //System.out.println("\n\nSECTION TWO:: PRACTICE MODE\n(QUESTION AND ANSWER)");
                //System.out.println("===========================\n=============================");
                Scanner msg= new Scanner( System.in );
                int m;
                String context[]=new String[20];
                //System.out.println("How many sentences will be in the combined context??");
                //int sentencenum= msg.nextInt();
                //System.out.println();
                //System.out.println("Enter a combined context: ");
                String content=JOptionPane.showInputDialog("Enter a combined context: ");
                int start=0;
                int end=content.length();
                char charcontent[]=new char[end-start];
                content.getChars(start,end,charcontent,0);
                JTextField contextfield;
                contextfield=new JTextField(1000);
                m=0;
                int start2=0,end2;
                String name;
                for(int index2=0; index2<end; index2++)
                {
                    end2=index2;
                    if(charcontent[index2]!='.')
                    {

                        continue;
                    }
                    context[m]=content.substring(start2,end2);
                    m++;
                    start2=index2+2;
                }

                int sentencenum=m;
                for(m=0; m<sentencenum; m++)
                {
                    int u=0;
                    StringTokenizer tokenss= new StringTokenizer(context[m]);
                    while(tokenss.hasMoreTokens())
                    {
                        position[u]=tokenss.nextToken();
                        //System.out.println(tokens.nextToken());
                        u++;
                    }
                    flag=false;
                    int v=0;

                    //PROCESSING NOUN PHRASE (NOUN+PRONOUN+ADVERB)
                    for(v=0; v<(Math.ceil(u/2)); v++)
                    {
                        flag=false;
                        //System.out.println(position[v]);
                        if(flag==true)
                        {
                            break;
                        }
                        String zz="";
                        String yy="";
                        Scanner ccc;
                        try
                        {
                            ccc=new Scanner(new File("C:\\NLP.txt"));
                            while(ccc.hasNext())
                            {
                                zz=ccc.next();
                                yy=ccc.next();
                                if(zz.equalsIgnoreCase(position[v]) && yy.equalsIgnoreCase("6"))
                                {
                                    //System.out.println("FOUND SOMETHING");
                                    np[m]=zz;
                                    flag=true;
                                    break;
                                }
                                if(zz.equalsIgnoreCase(position[v]) && yy.equalsIgnoreCase("1"))
                                {
                                    //System.out.println("FOUND SOMETHING");
                                    np[m]=zz;
                                    flag=true;
                                    break;
                                }
                                if(zz.equalsIgnoreCase(position[v]) && yy.equalsIgnoreCase("2"))
                                {
                                    //System.out.println("FOUND SOMETHING");
                                    np[m]=zz;
                                    //flag=true;
                                    break;
                                }
                                if(zz.equalsIgnoreCase(position[v]) && yy.equalsIgnoreCase("5"))
                                {
                                    //System.out.println("FOUND SOMETHING");
                                    np[m]=zz;
                                    //flag=true;
                                    break;
                                }
                            }
                        }
                        catch(Exception e4)
                        {
                            JOptionPane.showMessageDialog(null,"Unknown word detected!! Cannot found in the LEXICON!!\nPlease add the word in the LEXICON to get better answer!!");
                        }
                        //flag=false;
                        //System.out.println(position[v]);
                        String kk="";
                        String jj="";
                        Scanner ddd;
                        if(flag==false)
                        {
                            try
                            {
                                ddd=new Scanner(new File("C:\\NLP.txt"));
                                while(ddd.hasNext())
                                {
                                    kk=ddd.next();
                                    jj=ddd.next();
                                    if(kk.equalsIgnoreCase(position[v]) && jj.equalsIgnoreCase("5"))
                                    {
                                        //System.out.println("FOUND SOMETHING");
                                        np[m]=kk;
                                        flag=true;
                                        break;
                                    }
                                }
                            }
                            catch(Exception e5)
                            {
                                JOptionPane.showMessageDialog(null,"Unknown word detected!! Cannot found in the LEXICON!!\nPlease add the word in the LEXICON to get better answer!!");
                            }
                        }
                        if(flag==true)
                        {
                            break;
                        }
                        //flag=false;
                    }
                    //int d=u;
                    flag=false;
                    cn=0;

                    //VERB PHRASE PROCESSING (NOUN+ADJECTIVE+VERB+ADVERB+PREPOSITION)
                    for(v=(u/2); v<u; v++)
                    {
                        //flag=false;
                        //flag=false;
                        String rr="";
                        String uu="";
                        Scanner fff;
                        try
                        {
                            fff=new Scanner(new File("C:\\NLP.txt"));
                            while(fff.hasNext())
                            {
                                if(flag==true)
                                {
                                    if(rr.equalsIgnoreCase(position[v]) && uu.equalsIgnoreCase("6"))
                                    {
                                        vp[m]=vp[m]+" "+rr;
                                        verbphrase[m][cn]=rr;
                                        cn++;
                                        flag=true;
                                    }
                                    if(rr.equalsIgnoreCase(position[v]) && uu.equalsIgnoreCase("5"))
                                    {
                                        vp[m]=vp[m]+" "+rr;
                                        verbphrase[m][cn]=rr;
                                        cn++;
                                        flag=true;
                                    }
                                    if(rr.equalsIgnoreCase(position[v]) && uu.equalsIgnoreCase("4"))
                                    {
                                        vp[m]=vp[m]+" "+rr;
                                        verbphrase[m][cn]=rr;
                                        cn++;
                                        flag=true;
                                    }
                                    if(rr.equalsIgnoreCase(position[v]) && uu.equalsIgnoreCase("1"))
                                    {
                                        vp[m]=vp[m]+" "+rr;
                                        verbphrase[m][cn]=rr;
                                        cn++;
                                        flag=true;
                                    }
                                    if(rr.equalsIgnoreCase(position[v]) && uu.equalsIgnoreCase("2"))
                                    {
                                        vp[m]=vp[m]+" "+rr;
                                        verbphrase[m][cn]=rr;
                                        cn++;
                                        flag=true;
                                    }
                                    rr=fff.next();
                                    uu=fff.next();
                                }
                                else
                                {
                                    vp[m]=rr;
                                    verbphrase[m][cn]=rr;
                                    cn++;
                                    flag=true;
                                }
                            }
                        }
                        catch(Exception e6)
                        {
                            continue;
                        }
                    }
                    dd[m]=cn;
                    //
                }
                String npvp="NOUN PHRASE       VERB PHRASE\n===============================\n";
                //System.out.println("NOUN PHRASE       VERB PHRASE");
                //System.out.println("===============================");
                for(int l=0; l<m; l++)
                {
                    //System.out.println(np[l]+"   "+vp[l]);
                    npvp=npvp.concat(np[l]+"                        "+vp[l]+"\n");
                }
                JOptionPane.showMessageDialog(null,npvp);
                //System.out.println("\nYour context is acknowledged.");
                JOptionPane.showMessageDialog(null,"Your context is acknowledged.");
                JOptionPane.showMessageDialog(null,"Now type your questions based on given context, enter \"stop\" for exit");
                //System.out.println("\nNow type your questions based on given context, enter \"stop\" for exit");
                boolean q=false;
                //question = scanner.nextLine();
                while(!q)
                {
                    //question= new Scanner( System.in );
                    question=JOptionPane.showInputDialog("Enter a question based on your context: ");
                    //System.out.println("\nQuestion: ");
                    //question = scanner.nextLine();

                    if(question.equalsIgnoreCase("stop"))
                    {
                        q=true;
                        //System.exit(0);
                        break;
                    }
                    if(q==true)
                    {
                        break;
                    }
                    //tokenizer
                    int h=0;
                    StringTokenizer tokensss= new StringTokenizer(question);
                    while(tokensss.hasMoreTokens())
                    {
                        potques[h]=tokensss.nextToken();
                        //System.out.println(tokens.nextToken());
                        h++;
                    }
                    f=0;
                    boolean qnoun=false;
                    boolean qverb=false;
                    for(int g=0; g<h; g++)
                    {
                        for(int t=0; t<sentencenum; t++)
                        {
                            if(potques[g].equalsIgnoreCase(np[t]))
                            {
                                qnoun=true; //question is in noun form
                                f=t; //we found noun phrase in position t
                                break;
                            }
                        }
                        if(qnoun==true)
                        {
                            break;
                        }
                    }
                    if(qnoun==true) //question is in noun phrase form
                    {
                        //
                        try
                        {
                            System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                            Synthesizer  synthesizer =Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                            synthesizer.allocate();
                            synthesizer.resume();
                            synthesizer.speakPlainText(vp[f], null);
                        }
                        catch(Exception e1)
                        {
                            //e.printStackTrace();
                            JOptionPane.showMessageDialog(null,"Could not convert the answer in speech");
                        }
                        //System.out.println("Answer: "+vp[f]);
                        JOptionPane.showMessageDialog(null,"Answer: "+vp[f]);
                        //
                    }
                    else //question is in verb phrase form
                    {
                        //System.out.println("Answer: "+np[f]);
                        for(int g=0; g<h; g++)
                        {
                            for(int t=0; t<sentencenum; t++)
                            {
                                for(int r=0; r<dd[t]; r++)
                                {
                                    if(potques[g].equalsIgnoreCase(verbphrase[t][r]))
                                    {
                                        qverb=true; //question is in verb form
                                        vv=t; //we found noun phrase in position t
                                        break;
                                    }
                                }
                            }
                            /*if(qverb==true)
                            {
                            break;
                            }*/
                            if(qverb==true) //question is in verb phrase form
                            {
                                //
                                //
                                try
                                {
                                    System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                                    Synthesizer  synthesizer =Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                                    synthesizer.allocate();
                                    synthesizer.resume();
                                    //synthesizer.speakPlainText("Can you hear me now?", null);
                                    synthesizer.speakPlainText(np[vv], null);
                                    //synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                                    //synthesizer.deallocate();
                                }
                                catch(Exception e2)
                                {
                                    //e.printStackTrace();
                                    JOptionPane.showMessageDialog(null,"Could not convert the answer into speech");
                                }
                                //
                                JOptionPane.showMessageDialog(null,"Answer: "+np[vv]);
                                //System.out.println("Answer: "+np[vv]);
                                break;
                                //continue;
                                //
                            }
                        }
                    }
                }
                break;
            }
            case 3:
                //System.out.println("The program is terminated!!");
                JOptionPane.showMessageDialog(null,"The program is successfully terminated!!");
                System.exit(0);
                break;
            default:
                //System.out.println("Invalid choice, please try again!!");
                JOptionPane.showMessageDialog(null,"Invalid choice, please try again!!");
                break;
            }
        }
    }
}
