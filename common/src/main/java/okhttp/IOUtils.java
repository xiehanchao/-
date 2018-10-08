package okhttp;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**********************************************************************
 * 输入输出流工具类
 *
 * @类名 IOUtils
 * @包名 com.hotwheels
 * @author 谢晗超
 * @创建日期 2018/5/12
 ***********************************************************************/
public final class IOUtils {

    private IOUtils() {
        throw new AssertionError();
    }

    /**
     * 从输入流中读取数据转换为字符串
     *
     * @param inputStream 输入流
     * @return 字符串
     */
    public static String read(InputStream inputStream) {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 从输入流中读取数据转换为对象
     *
     * @param inputStream 输入流
     * @return 对象
     */
    public static Object readToObject(InputStream inputStream) {
        ObjectInputStream objectInputSteam = null;
        try {
            objectInputSteam = new ObjectInputStream(inputStream);
            return objectInputSteam.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputSteam != null) {
                    objectInputSteam.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 将输入流写入输出流中
     *
     * @param outputStream 输出流
     * @param inputStream 输入流
     * @return 是否成功写入
     */
    public static boolean write(OutputStream outputStream, InputStream inputStream) {
        try {
            byte[] data = new byte[1024];
            int length = -1;
            while ((length = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, length);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将可序列化对象写入输出流
     *
     * @param outputStream 输出流
     * @param serializable 可序列化对象
     * @return 是否成功写入
     */
    public static boolean writeFromSerializable(OutputStream outputStream, Serializable serializable) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 关闭可关闭对象（IO流）
     *
     * @param closeable 可关闭对象
     */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new RuntimeException("IOException occurred. ", e);
            }
        }
    }

    /**
     * 关闭可关闭对象，忽略异常
     *
     * @param closeable 可关闭对象
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // Ignored
            }
        }
    }

}
