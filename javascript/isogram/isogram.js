var Isogram = function(word) {

    var isNotSpaceOrHyphen = function(c){ return c !== '-' && c !== ' '; }

    var _word = word.toLowerCase()
                    .split('')
                    .filter(isNotSpaceOrHyphen);

    // more traditional / iterative solution
    this.isIsogramIter = function(){
    //this.isIsogram = function(){
		
		var letters = new Object(null);
		
		for(var i = 0; i < _word.length; i++){ 
		
			if(letters.hasOwnProperty(_word[i])){ return false; }
			else{ letters[_word[i]] = i; }
			
		}
		
		return true;
	};

    // recursive solution
    //this.isIsogramRecur = function(){
    this.isIsogram = function(){

		var checkLetterRecur = function(letters){
			
			var head = letters[0];
			var tail = letters.slice(1);
			
			if(tail.length === 0){ return true; }
			else if(tail.indexOf(head) > -1){ return false; }
			else{ return checkLetterRecur(tail); }

		};
		
		return checkLetterRecur(_word);
	};
};

module.exports = Isogram;