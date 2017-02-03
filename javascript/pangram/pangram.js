var Pangram = function(phrase){
    var lower = "abcdefghijklmnopqrstuvwxyz";

    var isLetter = function(c){ return lower.indexOf(c) >= 0; }
    var unique = function(acc, curr, idx, arr){
        return acc + ((arr.slice(idx+1).indexOf(curr) >= 0) ? "" : curr);
    };

    var letters = phrase.toLowerCase()
                        .split('')
                        .filter(isLetter)
                        .reduce(unique,"");

    this.isPangram = function(){
        return letters.length === lower.length;
    };

};

module.exports = Pangram;