package collections;

import java.io.File;
import javax.swing.JOptionPane;

/**
 * La classe abstraite <b>MyManager</b> impl&eacute;mente les fonctionnalit&eacute;s n&eacute;cessaires &agrave; la s&eacute;rialisation. <br>
 * Classes filles : EditorManager et CreatorManager
 * @author Corentin Machet
 * @version 2021.04.27
 */
public abstract class MyManager
{
    /**
     * File dont l'abstract path dirige vers le fichier de sauvegarde des serial datas
     */
    protected static final File serial_datas = new File(File.separator + "PicManager" + File.separator + "datas" + File.separator + "SERIAL_DATAS");

    /**
     * Objet java contenant les serial datas actuelles
     */
    private SerialData currentDatas;

    /**
     * Constructeur. R&eacute;cup&egrave;re les serial datas ou cr&eacute;e le fichier correspondant s'il n'existe pas
     */
    public MyManager()
    {
        File root = new File(File.separator);
        if (root.exists() && root.isDirectory())
        {
            File picmanager = new File(File.separator + "PicManager" + File.separator + "datas");
            if (picmanager.exists() && picmanager.isDirectory())
            {
                if (serial_datas.exists() && serial_datas.isFile())
                {
                    fetchSerialDatas();
                }
                else
                {
                    currentDatas = new SerialData();
                    pushSerialDatas();
                }
            }
            else
            {
                if (picmanager.mkdirs())
                {
                    currentDatas = new SerialData();
                    pushSerialDatas();
                }
                else
                {
                    System.err.println("Le ou les fichiers de sauvegarde requis sont introuvables.");
                    System.exit(10);
                }
            }
        }
        else
        {
            System.err.println("La racine des fichiers est introuvable.");
            System.exit(20);
        }
    }

    /**
     * R&eacute;cup&egrave;re les derni&egrave;res serial datas
     */
    public void fetchSerialDatas()
    {
        java.io.ObjectInputStream in = null;

        try
        {
            in = new java.io.ObjectInputStream(new java.io.FileInputStream(serial_datas.getAbsolutePath()));
            currentDatas = (SerialData) in.readObject();
        }
        catch (java.io.StreamCorruptedException sce)
        {
            sce.printStackTrace();
            JOptionPane.showMessageDialog(null, "The stream header is incorrect during the opening of the stream or the object reading.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch (java.lang.SecurityException se)
        {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "An untrusted subclass illegally overrides security-sensitive methods.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch (java.lang.NullPointerException npe)
        {
            npe.printStackTrace();
            JOptionPane.showMessageDialog(null, "The FileInputStream is null.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch (java.lang.ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Class " + currentDatas.getClass().getName() + " of the serialized object cannot be found.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch (java.io.InvalidClassException ice)
        {
            ice.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something is wrong with a class used by serialization.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch (java.io.OptionalDataException ode)
        {
            ode.printStackTrace();
            JOptionPane.showMessageDialog(null, "Primitive data was found in the stream instead of objects.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "An I/O error occurs while reading stream header.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (java.io.IOException ioe)
                {
                    ioe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "There is an I/O error ...", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(30);
                }
            }
        }
    }

    /**
     * Met &agrave; jour les serial datas
     */
    public void pushSerialDatas()
    {
        java.io.ObjectOutputStream out = null;

        try
        {
            out = new java.io.ObjectOutputStream(new java.io.FileOutputStream(serial_datas.getAbsolutePath()));
        }
        catch(java.io.IOException ioe)
        {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "An I/O error occurs while writing stream header", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch(SecurityException se)
        {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "An untrusted subclass illegally overrides security-sensitive methods", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch(NullPointerException npe)
        {
            npe.printStackTrace();
            JOptionPane.showMessageDialog(null, "The FileOutputStream is null", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }

        try
        {
            out.writeObject(currentDatas);
        }
        catch(java.io.InvalidClassException ice)
        {
            ice.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something is wrong with " + currentDatas.getClass().getName() + " class during serialization", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch(java.io.NotSerializableException nse)
        {
            nse.printStackTrace();
            JOptionPane.showMessageDialog(null, "Some object to be serialized does not implement the java.io.Serializable interface", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        catch(java.io.IOException ioe)
        {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Any exception thrown by the underlying OutputStream.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(30);
        }
        finally
        {
            try
            {
                out.flush();
                out.close();
            }
            catch(java.io.IOException ioe)
            {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "There is an I/O error ...", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(30);
            }
        }
    }

    /**
     * Retourne l'objet java courant qui contient les serial datas
     * @return les serial datas sous forme d'un objet SerialData
     * @see SerialData objet contenant les serial datas
     */
    public SerialData getCurrentDatas()
    {
        return currentDatas;
    }
}