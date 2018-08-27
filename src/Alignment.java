public enum Alignment { 
	
	Chaotic_Evil('C','E'),
	Chaotic_Neutral('C','N'),
	Chaotic_Good('C','G'),
	Neutral_Evil('N','E'),
	Neutral_Neutral('N','N'),
	Neutral_Good('N','G'),
	Lawful_Evil('L','E'),
	Lawful_Neutral('L','N'),
	Lawful_Good('L','G');
		
	public final char lawfulness;
	public final char goodness;
	
	Alignment(char law, char good) {
		lawfulness = law;
		goodness = good;
	}

	public int matchLevel(Alignment other) {
		int matchLevel = 0;
			
		if(this.lawfulness == other.lawfulness) {
			matchLevel++;
		}
		if(this.goodness == other.goodness) {
			matchLevel++;
		}
			
		if(matchLevel == 0) {
			//Check for pure opposite.
			if((this.lawfulness == 'C' && other.lawfulness == 'L') || (this.lawfulness == 'L' && other.lawfulness == 'C')) {
				//So we've got a chaotic and lawful mismatch
				if((this.goodness == 'G' && other.goodness == 'E')||(this.goodness == 'E' && other.goodness == 'G')) {
					//Good and evil are opposite. Opposite Match.
					return -2;
				}
			}				
		}
		
		return matchLevel;
	}
	public String toString() {
		return this.lawfulness+""+this.goodness;
	}		
}