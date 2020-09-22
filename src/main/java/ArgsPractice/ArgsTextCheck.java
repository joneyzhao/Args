package ArgsPractice;

import java.util.Arrays;
import java.util.List;

public class ArgsTextCheck {
    private String argsText;
    private List<String> schemaFlagList = Arrays.asList("-l", "-p", "-d");

    public ArgsTextCheck(String argsText){
        this.argsText = argsText;
    }

    public Boolean antiDuplicationCheck(){
        for(String schemaFlag: schemaFlagList){
            int counts = (argsText.length()-argsText.replaceAll(schemaFlag, "").length())/2;
            System.out.println("1===" + argsText);
            if(counts > 1){
                System.out.println("不允许输入重复flag！");
                return false;
            }
        }
        return true;
    }

    public Boolean illegalBlankSpaceBetweenFlagCheck(){
        Boolean hasIllegalBlankSpaceBetweenFlag = argsText.indexOf("- l") != -1 || argsText.indexOf("- p") != -1 || argsText.indexOf("- d") != -1;

        if(hasIllegalBlankSpaceBetweenFlag){
            System.out.println("不允许在-和flag存在空格！");
            return false;
        }
        return true;
    }

    public Boolean illegalNoBlankSpaceBetweenArgCheck(){
        Boolean noBlankSpaceBetweenArg = argsText.indexOf("-l-") != -1 || argsText.indexOf("-p-") != -1 || argsText.indexOf("-d-") != -1;

        if(noBlankSpaceBetweenArg){
            System.out.println("参数之间未用空格分割！");
            return false;
        }
        return true;
    }
}
