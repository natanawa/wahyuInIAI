/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package properti;


import javax.swing.text.*;

/**
 *
 * @author dimmas digital
 */
public class Numeric {
    
    public PlainDocument isNumeric(){
        
        PlainDocument insertNumber=new PlainDocument(){
            public void insertString(int offs,String str, AttributeSet a)throws BadLocationException{
                StringBuffer temp=new StringBuffer();
                int h=0;
                char []entryData=str.toCharArray();
                for(int i=0;i<entryData.length;i++){
                    boolean isDigit=Character.isDigit(entryData[i]);
                    if(isDigit==true){
                        entryData[h]=entryData[i];
                        h++;
                    }
                }
                temp.append(entryData,0,h);
                super.insertString(offs, new String(temp), a);
            }
        };
        return insertNumber;
    }
}
