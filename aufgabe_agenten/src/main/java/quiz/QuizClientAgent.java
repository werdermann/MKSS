package quiz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import jadex.bridge.IInternalAccess;
import jadex.bridge.service.ServiceScope;
import jadex.commons.future.IFuture;
import jadex.commons.gui.SGUI;
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.OnService;
import jadex.micro.annotation.RequiredService;
import jadex.micro.annotation.RequiredServices;

/**
 *  The quiz client agent.
 */
@Agent
@RequiredServices({@RequiredService(name="quizservice", type=IQuizService.class, scope = ServiceScope.PLATFORM)})
public class QuizClientAgent
{
	@Agent
	protected IInternalAccess agent;
	
	/** The quiz service. */
	protected IQuizService quizservice;
	
	/** The gui. */
	protected QuizGui gui = new QuizGui();
	
	/** The question count. */
	protected int questioncnt;
	
	@OnService(name="quizservice")
	protected void subscribeAtService(IQuizService qs)
	{
		System.out.println("Client found quiz service: "+qs);

		qs.participate();
		
		// if has no quizservice, subscribe and show connection in gui
		// handle quiz events of service
		//   on QuestionEvents display the question in gui
		//   on ResultEvent display the result in gui
	}
	
	/**
	 *  The quiz gui.
	 */
	public class QuizGui
	{
		protected JFrame f;
		protected JLabel conl;
		protected JTextArea ta;
		protected JLabel la;
		protected ButtonGroup bg;
		
		/**
		 *  Create a new quiz gui.
		 */
		public QuizGui()
		{
			SwingUtilities.invokeLater(()-> 
			{
				f = new JFrame();
				JPanel p = new JPanel(new BorderLayout());
				conl = new JLabel(" ");
				ta = new JTextArea();
				JPanel n = new JPanel(new BorderLayout());
				n.add(conl, BorderLayout.NORTH);
				n.add(ta, BorderLayout.CENTER);
				p.add(BorderLayout.NORTH, n);
				
				JPanel bp = new JPanel(new GridLayout(0, 1));
				bg = new ButtonGroup();
				for(int i=0; i<4; i++)
				{
					final int fi = i;
					JRadioButton b = new JRadioButton();
					b.addActionListener(a -> 
					{
						agent.scheduleStep(x ->
						{
							if(quizservice!=null)
								quizservice.processAnswer(fi, questioncnt);
							return IFuture.DONE;
						});
					});
					bg.add(b);
					bp.add(b);
				}
				
				p.add(BorderLayout.CENTER, bp);
				la = new JLabel(" ");
				p.add(BorderLayout.SOUTH, la);
				
				f.setTitle("Quiz UI of "+agent.getId());
				f.setLayout(new BorderLayout());		
				f.getContentPane().add(p, BorderLayout.CENTER);
				f.pack();
				f.setVisible(true);
				f.setLocation(SGUI.calculateMiddlePosition(f));
			});
		}
		
		/**
		 *  Set a question
		 */
		public void setQuestion(Question question)
		{
			SwingUtilities.invokeLater(()-> 
			{
				ta.setText(question!=null? question.getQuestion(): "");
				int i=0;
				for(Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();)
				{
					AbstractButton button = buttons.nextElement();
					button.setText(question!=null? question.getAnswers().get(i++): "");
				}
				bg.clearSelection();
			});
		}
		
		/**
		 *  Set result.
		 */
		public void setResult(String result)
		{
			SwingUtilities.invokeLater(()-> 
			{
				la.setText(result);
			});
		}
		
		/**
		 *  Set the title.
		 */
		public void setQuizService(IQuizService quizser)
		{
			SwingUtilities.invokeLater(()-> 
			{
				conl.setText(quizser!=null? "Connected with "+quizser: "");
			});
		}
	}
}
