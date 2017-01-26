//
// This is only a SKELETON file for the "Bob" exercise. It's been provided as a
// convenience to get you started writing code faster.
//

var Bob = function() {};

Bob.prototype.hey = function(input) {

    var nothing = function(s){ return s.length === 0; };
    
    var question = function (s) { 
        return s.length > 0 && s.charAt(s.length - 1) === '?'; 
    };

    var yelling = function(s){ 
        return (s.toUpperCase() === s) && s.match(/[a-z]/i); 
    };

    var bobSays = function(phrase){
        
        phrase = phrase.trim();

        if(nothing(phrase)){ return "Fine. Be that way!"; }
        
        if(yelling(phrase)){ return "Whoa, chill out!"; }
        
        if(question(phrase)){ return "Sure."; }

        return "Whatever."
    };

    return bobSays(input);
        
};

module.exports = Bob;
