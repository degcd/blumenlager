package UI;

public interface ISubjekt {

    public void registriere(IBeobachter b);

    public void deregistriere(IBeobachter b);
    
    public void benachrichtige();
}
