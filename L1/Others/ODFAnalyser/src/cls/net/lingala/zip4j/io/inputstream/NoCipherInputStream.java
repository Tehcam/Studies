package cls.net.lingala.zip4j.io.inputstream;

import cls.net.lingala.zip4j.crypto.Decrypter;
import cls.net.lingala.zip4j.model.LocalFileHeader;

import java.io.IOException;

class NoCipherInputStream extends CipherInputStream {

  public NoCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader,
                             char[] password, int bufferSize) throws IOException {
    super(zipEntryInputStream, localFileHeader, password, bufferSize);
  }

  @Override
  protected Decrypter initializeDecrypter(LocalFileHeader localFileHeader, char[] password) {
    return new NoDecrypter();
  }

  static class NoDecrypter implements Decrypter {

    @Override
    public int decryptData(byte[] buff, int start, int len) {
      return len;
    }
  }
}
