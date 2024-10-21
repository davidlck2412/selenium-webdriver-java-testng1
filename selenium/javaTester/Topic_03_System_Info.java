package javaTester;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;

public class Topic_03_System_Info {
    public static void main(String args[]) {
        String osName = System.getProperty("os.name");
        Keys keys;
        System.out.println(osName);
        if (osName.startsWith("Window")){
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

        Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;

        String charater = Platform.getCurrent().is(Platform.WINDOWS) ? "\\" : "/";

        String hcmName = "HoChiMinh.jpg";
        String dnName = "DaNang.jpg";
        String hpName = "HaiPhong.jpg";
        String ndName = "NamDinh.jpg";
        String qnName = "Quangninh.jpg";

        String hcmFilePAth = osName + charater + "uploadFiles" + charater + hcmName;
        String dnFilePAth = osName + charater + "uploadFiles" + charater + dnName;
        String hpFilePAth = osName + charater + "uploadFiles" + charater + hpName;
        String ndFilePAth = osName + charater + "uploadFiles" + charater + ndName;
        String qnFilePAth = osName + charater +"uploadFiles" + charater + qnName;

        System.out.println(hcmFilePAth);
        System.out.println(dnFilePAth);
        System.out.println(hpFilePAth);
        System.out.println(ndFilePAth);
        System.out.println(qnFilePAth);
    }
}
