package sk.hovan.andrej.skuska.domacej;


public class FrequencyTable {
	

	String[] slova;
	int[] vyskyty;

	/**
	 * Konstruktor: vytvori prazdnu frekvencnu tabulku
	 */
	public FrequencyTable() {
		slova = new String[0];
		vyskyty = new int[0];
	}

	/**
	 * Vyprazdni obsah tabulky (vratene vlozenych slov)
	 */
	public void clear() {
		slova = new String[0];
		vyskyty = new int[0];
	}

	/**
	 * Vrati pocet vyskytov slova. V pripade, ze sa slovo v tabulke nenachadza,
	 * vrati 0
	 * 
	 * @param word retazec, ktoreho pocet vyskytov chceme zistit
	 * @return pocet vyskytov zadaneho slova (retazca)
	 */
	public int getNumberOfOccurrences(String word) {
		int pocitadlo = 0;
		for (int i = 0; i < slova.length; i++) {
			if (slova[i].equals(word)) {
				return vyskyty[i];
			}
		}
		return 0;
	}

	/**
	 * Poznaci novy vyskyt slova vo frekvencnej tabulke (zvysi pocitadlo priradene
	 * danemu slovu o 1). Ak take slovo sa v tabulke nenachadza, nastavi pocet jeho
	 * vyskytov na 1
	 * 
	 * @param word slovo, ktoreho vyskyt chceme poznacit vo frekvencnej tabulke
	 */
	public void addOccurrence(String word) {
		int pocitadlo = 0;
		for (int i = 0; i < slova.length; i++) {
			if (slova[i].equals(word)) {
				vyskyty[i] ++;
				return;
			} else {
				pocitadlo ++;
			}
		}
		if (pocitadlo == slova.length) {
			String[] noveSlova = new String[slova.length+1];
			int[] noveVyskyty = new int[vyskyty.length+1];
			System.arraycopy(slova, 0, noveSlova, 0, slova.length);
			noveSlova[noveSlova.length-1] = word;
			System.arraycopy(vyskyty, 0, noveVyskyty, 0, vyskyty.length);
			noveVyskyty[noveVyskyty.length-1] = 1;
			slova = noveSlova;
			vyskyty = noveVyskyty;
		}
	}

	/**
	 * Vrati pocet slov vo frekvencnej tabulke (vsetky maju nenulovy pocet vyskytov)
	 * 
	 * @return pocet slov vo frekvencnej tabulke
	 */
	public int getWordCount() {
		return slova.length;
	}

	/**
	 * Vrati slova vo frekvencnej tabulke v novovytvorenom poli retazcov
	 * 
	 * @return referencia na novovytvorene pole retazcov so slovami v tabulke
	 */
	public String[] getWords() {
		return slova.clone();
	}

	/**
	 * Vrati obsah frekvencnej tabulky ako retazec vo formate
	 * [slovo1=pocetVyskytov1, slovo2=pocetVyskytov2]
	 */
	public String toString() {
		StringBuilder obsah = new StringBuilder("[");
		for (int i = 0; i < slova.length-1; i++) {
			obsah.append( slova[i] + "=" + vyskyty[i] + ", " );
		}
		obsah.append( slova[slova.length-1] + "=" + vyskyty[slova.length-1] + "]" );
		return obsah.toString();
	}


}
