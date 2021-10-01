public class PenduException extends Exception
{
    private static final long serialVersionUID = 1L;
    private String motInvalide;
    
    public PenduException(String err)
    {
        super(err);
        motInvalide = null;
    }

    public PenduException(String err, String mot)
    {
        super(err);
        motInvalide = mot;
    }

    @Override
    public String getMessage()
    {
        String str = super.getMessage();
        str += "\n\tMot invalide : " + motInvalide;
        return str; 
    }
}