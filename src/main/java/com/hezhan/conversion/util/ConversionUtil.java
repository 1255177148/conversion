package com.hezhan.conversion.util;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;

/**
 * @Author hezhan
 * @Date 2020/10/21 16:05
 * word和pdf互转工具类
 */
@Component
public class ConversionUtil {

    /**
     * word转pdf
     * @param response
     * @param file
     */
    public void toPdf(HttpServletResponse response, MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".pdf");
        response.setCharacterEncoding("utf-8");
        String s = "<License><Data><Products><Product>Aspose.Total for Java</Product><Product>Aspose.Words for Java</Product></Products><EditionType>Enterprise</EditionType><SubscriptionExpiry>20991231</SubscriptionExpiry><LicenseExpiry>20991231</LicenseExpiry><SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber></Data><Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature></License>";
        ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());
        License license = new License();
        license.setLicense(is);
        Document document = new Document(file.getInputStream());
        document.save(response.getOutputStream(), SaveFormat.PDF);
    }

    /**
     * pdf转 word doc格式的
     * @param response
     * @param file
     */
    public void toDoc(HttpServletResponse response, MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        response.setContentType("application/msword");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".doc");
        response.setCharacterEncoding("utf-8");
        String s = "<License><Data><Products><Product>Aspose.Total for Java</Product><Product>Aspose.Words for Java</Product></Products><EditionType>Enterprise</EditionType><SubscriptionExpiry>20991231</SubscriptionExpiry><LicenseExpiry>20991231</LicenseExpiry><SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber></Data><Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature></License>";
        ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());
        License license = new License();
        license.setLicense(is);
        Document document = new Document(file.getInputStream());
        document.save(response.getOutputStream(), SaveFormat.DOC);
    }
}
