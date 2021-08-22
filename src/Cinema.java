import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Cinema extends JPanel implements MouseListener {
	private JPanel filmebkPanel, valorPanel, botoesPanel, pagPanel, maisfilmesPanel;
	private JLabel tituloFilme, imgFilme, imgFilme1, imgFilme2, descFilme, valorFilme, legFilme, descBtnV, descBtnVE, descBtnA,
			formPag, tituloYourName, tituloDBE, tituloAV, tituloFilmePanel;
	private ImageIcon imgiFilme, imgiYN, imgiDBE, imgiAV;
	private JProgressBar pbBarra;
	
	
	
	
	
	private JButton[] botoes = new JButton[100];
	private JButton btnVFilm, btnVEFilm, btnAFilm, btnFinalizar, btnTrocar, btnYourName, btnDBE, btnAV;
	private ButtonGroup btnGroup;
	private JRadioButton Cartao, Dinheiro;
	private JTabbedPane tpAbas;

	private int num[] = new int[100];
	private int porcem, click, valorIngresso = 20;
	private double quantIngressI, quantIngressM;

	public Cinema() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.WHITE);



//		INICIANDO PAINEL FILME
		filmebkPanel = new JPanel(null);
		filmebkPanel.setBounds(100, 45, 300, 500);
		add(filmebkPanel);
//		FINALIZANDO PAINEL FILME

//		INICIANDO AREA FILME
		tituloFilme = new JLabel("Your Name");
		tituloFilme.setFont(new Font("Arial", Font.BOLD, 25));
		tituloFilme.setBounds(83, 12, 200, 25);
		imgiFilme = new ImageIcon("E:\\Java\\Projeto Final\\Filme 1.png");
		imgFilme = new JLabel(imgiFilme);
		imgFilme.setBounds(50, 60, 200, 250);
		descFilme = new JLabel(
				"<html> Mitsuha é a filha do prefeito de uma pequena cidade, mas sonha em tentar a sorte em Tóquio. Taki trabalha em um restaurante em Tóquio e deseja largar o seu emprego. Os dois não se conhecem, mas estão conectados pelas imagens de seus sonhos. <br><br> <u> Criado por: </u> Makoto Shinkai </html>");
		descFilme.setBounds(40, 330, 250, 150);
		filmebkPanel.add(tituloFilme);
		filmebkPanel.add(imgFilme);
		filmebkPanel.add(descFilme);
//		FINALIZANDO AREA FILME

//		INICIANDO PAINEL VALOR
		valorPanel = new JPanel(null);
		valorPanel.setBounds(100, 552, 160, 110);
		valorPanel.setBackground(Color.decode("#f5f5f5"));
		valorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(valorPanel);
//		FINALIZANDO PAINEL VALOR

//		INICIALIZANDO AREA VALOR
		valorFilme = new JLabel("Valor do ingresso: R$" + valorIngresso);
		valorFilme.setBounds(10, 0, 150, 50);
		valorPanel.add(valorFilme);

		legFilme = new JLabel("Legenda:");
		legFilme.setBounds(10, 25, 150, 50);
		valorPanel.add(legFilme);

		btnVFilm = new JButton();
		btnVFilm.setBounds(65, 44, 15, 15);
		btnVFilm.setBackground(Color.GREEN);
		btnVFilm.setEnabled(false);
		valorPanel.add(btnVFilm);
		descBtnV = new JLabel("Disponivel");
		descBtnV.setBounds(84, 42, 80, 20);
		valorPanel.add(descBtnV);

		btnVEFilm = new JButton();
		btnVEFilm.setBounds(65, 64, 15, 15);
		btnVEFilm.setBackground(Color.RED);
		valorPanel.add(btnVEFilm);
		descBtnVE = new JLabel("Inteira");
		descBtnVE.setBounds(84, 62, 80, 20);
		valorPanel.add(descBtnVE);

		btnAFilm = new JButton();
		btnAFilm.setBounds(65, 84, 15, 15);
		btnAFilm.setBackground(Color.BLUE);
		valorPanel.add(btnAFilm);
		descBtnA = new JLabel("Meia");
		descBtnA.setBounds(84, 82, 80, 20);
		valorPanel.add(descBtnA);
//		FINALIZANDO AREA VALOR

//		INICIANDO PAINEL BOTÕES
		botoesPanel = new JPanel(new GridLayout(10, 10, 10, 10));
		botoesPanel.setBounds(680, 35, 575, 575);
		botoesPanel.setBackground(Color.decode("#f5f5f5"));
		botoesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(botoesPanel);
//		FINALIZANDO PAINEL BOTÕES

//		INICIANDO AREA BOTÕES
		for (int i = 0; i < 100; i++) {
			botoes[i] = new JButton("" + i);
			botoes[i].setBackground(Color.decode("#009900"));
			botoes[i].setForeground(Color.WHITE);
			botoes[i].setFocusable(false);
			botoes[i].addMouseListener(this);
			botoesPanel.add(botoes[i]);
		}
//		FINALIZANDO AREA BOTÕES

//		INICIANDO PROGRESS BAR
		pbBarra = new JProgressBar(JProgressBar.VERTICAL);
		pbBarra.setBounds(625, 35, 50, 575);
		pbBarra.setStringPainted(true);
		pbBarra.setString("0%");
		pbBarra.setEnabled(true);
		pbBarra.setForeground(Color.GREEN);
		pbBarra.setBackground(Color.WHITE);
		add(pbBarra);
//		FINALIZANDO PROGRESS BAR

//		INICIANDO PAINEL FORMAS DE PAGAMENTO
		pagPanel = new JPanel(null);
		pagPanel.setBounds(680, 615, 145, 50);
		pagPanel.setBackground(Color.decode("#f5f5f5"));
		pagPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(pagPanel);
//		FINALIZANDO PAINEL FORMAS DE PAGAMENTO

//		INICIANDO AREA FORMAS DE PAGAMENTO
		formPag = new JLabel("Forma de pagamento:");
		formPag.setBounds(10, 0, 150, 25);
		formPag.setForeground(Color.BLACK);
		pagPanel.add(formPag);

		btnGroup = new ButtonGroup();

		Cartao = new JRadioButton("Cartão");
		Cartao.setBounds(5, 18, 63, 25);
		Cartao.setContentAreaFilled(false);
		btnGroup.add(Cartao);
		pagPanel.add(Cartao);

		Dinheiro = new JRadioButton("Dinheiro");
		Dinheiro.setBounds(70, 18, 72, 25);
		Dinheiro.setContentAreaFilled(false);
		btnGroup.add(Dinheiro);
		pagPanel.add(Dinheiro);
//		FINALIZANDO AREA FORMAS DE PAGAMENTO

//		INICIANDO BOTÃO FINALIZAR
		btnFinalizar = new JButton("Finalizar pedido");
		btnFinalizar.setBounds(1105, 615, 150, 30);
		btnFinalizar.setFocusable(false);
		add(btnFinalizar);
//		FINALIZANDO BOTÃO FINALIZAR

//		INICIANDO BOTÃO TROCAR FILME
		btnTrocar = new JButton("Trocar Filme");
		btnTrocar.setBounds(1105, 650, 150, 30);
		btnTrocar.setFocusable(false);
		add(btnTrocar);
//		FINALIZANDO BOTÃO TROCAR FILME

//		INICIANDO PAINEL +FILMES
		tituloFilmePanel = new JLabel("Outros Filmes: ");
		tituloFilmePanel.setBounds(638, 125, 200, 30);
		tituloFilmePanel.setFont(new Font("Arial", Font.BOLD, 20));
		tituloFilmePanel.setVisible(false);
		add(tituloFilmePanel);
		maisfilmesPanel = new JPanel(null);
		maisfilmesPanel.setBounds(625, 160, 630, 280);
		maisfilmesPanel.setBackground(Color.decode("#f5f5f5"));
		maisfilmesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		maisfilmesPanel.setVisible(false);
		add(maisfilmesPanel);
//		FINALIAZNDO PAINEL +FILMES

//		INICIANDO AREA +FILMES
		imgiYN = new ImageIcon("E:\\Java\\Projeto Final\\Filme 1.png");
		btnYourName = new JButton(imgiYN);
		btnYourName.setBounds(5, 5, 200, 250);
		tituloYourName = new JLabel("Your Name");
		tituloYourName.setFont(new Font("Arial", Font.BOLD, 15));
		tituloYourName.setBounds(65, 255, 135, 25);
		maisfilmesPanel.add(btnYourName);
		maisfilmesPanel.add(tituloYourName);

		imgiDBE = new ImageIcon("E:\\Java\\Projeto Final\\Filme 2.png");
		btnDBE = new JButton(imgiDBE);
		imgFilme1 = new JLabel(imgiDBE);
		imgFilme1.setBounds(50, 60, 200, 250);
		filmebkPanel.add(imgFilme1);
		imgFilme1.setVisible(false);
		btnDBE.setBounds(215, 5, 200, 250);
		tituloDBE = new JLabel("Dragon Ball Evolution");
		tituloDBE.setFont(new Font("Arial", Font.BOLD, 15));
		tituloDBE.setBounds(235, 255, 155, 25);
		maisfilmesPanel.add(tituloDBE);
		maisfilmesPanel.add(btnDBE);
		
		imgiAV = new ImageIcon("E:\\Java\\Projeto Final\\Filme 3.png");
		btnAV = new JButton(imgiAV);
		imgFilme2 = new JLabel(imgiAV);
		imgFilme2.setBounds(50, 60, 200, 250);
		filmebkPanel.add(imgFilme2);
		imgFilme2.setVisible(false);
		btnAV.setBounds(425, 5, 200, 250);
		tituloAV = new JLabel("O Último Mestre do Ar");
		tituloAV.setFont(new Font("Arial", Font.BOLD, 15));
		tituloAV.setBounds(445, 255, 170, 25);
		maisfilmesPanel.add(tituloAV);
		maisfilmesPanel.add(btnAV);
//		FINALIZANDO AREA +FILMES

	}

	public void definirEventos() {
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = 0;
				valor = quantIngressI * valorIngresso;
				valor = valor + ((quantIngressM / 2) * valorIngresso);
				String formapag = "";
				String selecao = "Selecionados: ";
				if (Cartao.isSelected()) {
					formapag = "Cartão";
					JOptionPane.showMessageDialog(null,
							"Quantidade de inteira: " + quantIngressI + "\nQuantidade de meia: " + quantIngressM
									+ "\nForma de pagamento: " + formapag + "\nValor total: " + valor);
				} else if (Dinheiro.isSelected()) {
					formapag = "Dinheiro";
					JOptionPane.showMessageDialog(null,
							"Quantidade de inteira: " + quantIngressI + "\nQuantidade de meia: " + quantIngressM
									+ "\nForma de pagamento: " + formapag + "\nValor total: " + valor);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento");
				}

			}
		});

		btnTrocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (click == 0) {
					btnFinalizar.setVisible(false);
					pagPanel.setVisible(false);
					pbBarra.setVisible(false);
					botoesPanel.setVisible(false);
					maisfilmesPanel.setVisible(true);
					tituloFilmePanel.setVisible(true);
					click = 1;
				} else {
					btnFinalizar.setVisible(true);
					pagPanel.setVisible(true);
					pbBarra.setVisible(true);
					botoesPanel.setVisible(true);
					maisfilmesPanel.setVisible(false);
					tituloFilmePanel.setVisible(false);
					click = 0;
				}
			}
		});

		btnYourName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloFilme.setText("Your Name");
				tituloFilme.setBounds(83, 12, 200, 25);
				imgFilme.setVisible(true);
				imgFilme1.setVisible(false);
				imgFilme2.setVisible(false);
				descFilme.setText(
						"<html> Mitsuha é a filha do prefeito de uma pequena cidade, mas sonha em tentar a sorte em Tóquio. Taki trabalha em um restaurante em Tóquio e deseja largar o seu emprego. Os dois não se conhecem, mas estão conectados pelas imagens de seus sonhos. <br><br> <u> Criado por: </u> Makoto Shinkai </html>");
				descFilme.setBounds(40, 330, 250, 150);
				valorIngresso = 20;
				valorFilme.setText("Valor do ingresso: R$" + valorIngresso);
			}
		});
		btnDBE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloFilme.setText("Dragon Ball Evolution");
				tituloFilme.setBounds(20, 12, 280, 25);
				imgFilme.setVisible(false);
				imgFilme1.setVisible(true);
				imgFilme2.setVisible(false);
				descFilme.setText(
						"<html> Goku ganha uma esfera do dragão mística de presente de seu avô. Existem apenas seis outras no mundo todo, e reza a lenda que será concedido um desejo a quem possuir todas as sete. Goku e seus amigos embarcam em uma jornada épica para recolher as sete esferas do dragão e salvar o planeta da destruição. <br><br> <u> Dirigido por: </u> James Wong </html>");
				descFilme.setBounds(40, 320, 250, 170);
				valorIngresso = 15;
				valorFilme.setText("Valor do ingresso: R$" + valorIngresso);
			}
		});
		
		btnAV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloFilme.setText("O Último Mestre do Ar");
				tituloFilme.setBounds(20, 12, 280, 25);
				imgFilme.setVisible(false);
				imgFilme1.setVisible(false);
				imgFilme2.setVisible(true);
				descFilme.setText(
						"<html> The Last Airbender é um filme americano de 2010, dos gêneros aventura, ação e fantasia, dirigido por M. Night Shyamalan. É baseado na série animada de televisão Avatar: The Last Airbender, criada por Michael Dante DiMartino e Bryan Konietzko para a Nickelodeon Animation Studios. <br><br> <u> Dirigido por: </u> M. Night Shyamalan\r\n"
						+ " </html>");
				descFilme.setBounds(40, 320, 250, 170);
				valorIngresso = 22;
				valorFilme.setText("Valor do ingresso: R$" + valorIngresso);
			}
		});
	}

//	INICIO METODO PARA MUDAR BK DO BUTTON
	public void Bk(int n, int botao) {
		if (num[n] == 0) {
			botoes[botao].setBackground(Color.red);
			num[n]++;
			porcem++;
			ProgressBar(porcem);
			quantIngressI++;
		} else if (num[n] == 1) {
			botoes[botao].setBackground(Color.blue);
			num[n]++;
			quantIngressI--;
			quantIngressM++;
		} else {
			botoes[botao].setBackground(Color.decode("#009900"));
			num[n] = 0;
			porcem--;
			ProgressBar(porcem);
			pbBarra.setValue(pbBarra.getValue() - 2);
			quantIngressM--;
		}
	}
//	FIM METODO PARA MUDAR BK DO BUTTON

//	INICIANDO METODO PROGRESS BAR
	public void ProgressBar(int porcem) {
		if (porcem < 100) {
			pbBarra.setString(porcem + "%");
			pbBarra.setValue(pbBarra.getValue() + 1);
		} else {
			JOptionPane.showMessageDialog(null, "A Sala esta lotada!");
		}

		if (pbBarra.getValue() >= 33 && pbBarra.getValue() < 65) {
			pbBarra.setForeground(Color.YELLOW);
		} else if (pbBarra.getValue() >= 66 && pbBarra.getValue() < 79) {
			pbBarra.setForeground(Color.ORANGE);
		} else if (pbBarra.getValue() >= 80) {
			pbBarra.setForeground(Color.RED);
		}

	}
//	FINALIZANDO METODO PROGRESS BAR

//	INICIO METODO DE PINTAR
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.decode("#cccccc"));
		Line2D divisao = new Line2D.Float(500, 60, 500, 660);
		g2.draw(divisao);
	}
//	FIM METODO DE PINTAR

	public static void main(String args[]) {

		JFrame frame = new JFrame("Sala de Cinema");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Cinema());
		frame.setVisible(true);

		frame.setBounds(5, 5, 1355, 725);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 100; i++) {
			if (e.getSource() == botoes[i]) {
				Bk(i, i);
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
