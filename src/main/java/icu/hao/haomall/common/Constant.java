package icu.hao.haomall.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {
    public static final String SALT = "ojiawd]aw./,mpd][]]p";
    public static final String HAOMALL_USER = "haomall_user";

    public static String uploadFileDir;
    @Value("${upload.file.dir}")
    public void setUploadFileDir(String uploadFileDir) {
        this.uploadFileDir = uploadFileDir;
    }
}
