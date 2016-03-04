package gui;


abstract class GUIFactory
{
	public static final String LOGIN_GUI = "Login";
	public static final String MENU_GUI = "Menu";
	
	public LoginGUI getLogin()
	{
		return new LoginGUI();
	}
	
	public MenuGUI getMenu(String s)
	{
		return new MenuGUI(s);
	}
	
}