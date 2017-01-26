var Hamming = function() {}

Hamming.prototype.compute = function(dna1, dna2) {
    
    if(dna1.length !== dna2.length){ throw new Error('DNA strands must be of equal length.'); }

    var s1 = dna1.split('');
    var s2 = dna2.split('');

    var zipped = s1.map(function (element, index) { return [element, s2[index]]; });

    var encode = function(e){ return (e[0] == e[1]) ? 0 : 1 };
    var sum = function(a, b){ return a + b; };

    // there probably is a better way to sum an array
    // this is what I came up with though :/
    return zipped.map(encode).reduce(sum, 0); 
};


module.exports = Hamming;