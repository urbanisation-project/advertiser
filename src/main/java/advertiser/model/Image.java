package advertiser.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    private long size;
    private String uuid;
    private String systemName;

    @Lob
    @Column(length = 1000)
    private byte[] data;

    @Transient
    public static Image build() {
        String uuid = UUID.randomUUID().toString();
        Image image = new Image();
        Date now = new Date();
        image.setUuid(uuid);
        image.setSystemName("default");
        image.setId(-1L);
        return image;
    }

    @Transient
    public void setFiles(MultipartFile file) {
        setFileType(file.getContentType());
        setSize(file.getSize());
        setSize(file.getSize());
    }

    @Transient
    public byte[] scale(int width, int height) throws Exception {

        if (width == 0 || height == 0)
            return data;

        ByteArrayInputStream in = new ByteArrayInputStream(data);

        try {
            BufferedImage img = ImageIO.read(in);

            java.awt.Image scaledImage = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            BufferedImage imgBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            imgBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0), null);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            ImageIO.write(imgBuff, "jpg", buffer);
            setData(buffer.toByteArray());
            return buffer.toByteArray();

        } catch (Exception e) {
            throw new Exception("IOException in scale");
        }
    }

    private static InputStream getResourceFileAsInputStream(String fileName) {
        ClassLoader classLoader = Image.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }

    @Transient
    public static Image defaultImage() throws Exception {
        InputStream is = getResourceFileAsInputStream("notfound.jpg");
        String fileType = "image/jpeg";
        byte[] bdata = FileCopyUtils.copyToByteArray(is);
        Image image = new Image(0L,null, fileType, 0, null, null, bdata);
        return image;
    }

    @Transient
    public static Image defaultImage(int width, int height) throws Exception {
        Image defaultImage = defaultImage();
        defaultImage.scale(width, height);
        return defaultImage;
    }

    @Transient
    public static Image buildImage(MultipartFile file) {
        String fileName = file.getOriginalFilename();

        Image image = Image.build();
        image.setFileName(fileName);
        image.setFiles(file);

        try {
            image.setData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}