package UI;

public interface Subjekt {

    public void registriere(Beobachter b);

    public void deregistriere(Beobachter b);
    
    public void benachrichtige();
}
