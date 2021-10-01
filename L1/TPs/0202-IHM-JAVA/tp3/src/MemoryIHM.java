public class MemoryIHM
{
    public static void main(String[] args)
    {
        /*
        if(args.length <= 0)
        {
            System.err.println("Le niveau de difficulte n'est pas specifie.\n\t-F facile\n\t-M moyen\n\t-D difficile");
            return;
        }
        if(args[0].length() != 2 || args[0].charAt(0) != '-')
        {
            System.err.println("Argument invalide.\n\t-F facile\n\t-M moyen\n\t-D difficile");
            return;
        }
        switch(args[0].charAt(1))
        {
            case 'F' : 
                new ExempleJLabelImage(Difficulte.FACILE);
                break;
            case 'M' : 
                new ExempleJLabelImage(Difficulte.MOYEN);
                break;
            case 'D' : 
                new ExempleJLabelImage(Difficulte.DIFFICILE);
                break;
            default : 
                System.err.println("Argument invalide.\n\t-F facile\n\t-M moyen\n\t-D difficile");
                return;
        }
        */
        new Configuration();
    }
}