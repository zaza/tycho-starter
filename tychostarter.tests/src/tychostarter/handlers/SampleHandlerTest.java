package tychostarter.handlers;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withText;
import static org.junit.Assert.assertNotNull;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

public class SampleHandlerTest  {

	private SWTWorkbenchBot bot;

	@Before
	public void setUp() {
		bot = new SWTWorkbenchBot();
	}
	
	@Test
	public void openDialog() {
		bot.menu("Sample Menu").menu("Sample Command").click();
		SWTBotShell dlg = bot.shell("Tycho Starter");
		assertNotNull(dlg);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Matcher matcher = allOf(widgetOfType(Label.class), withText("Hello, Eclipse world"));
		@SuppressWarnings("unchecked")
		SWTBotLabel label = new SWTBotLabel((Label) dlg.bot().widget(matcher));
		assertNotNull(label);
		dlg.bot().button("OK").click();
	}
}
