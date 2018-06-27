package UI;

public interface ISprachSubjekt {

    public void registriere(ISprachBeobachter b);

    public void deregistriere(ISprachBeobachter b);
    
    public void benachrichtige();
}
