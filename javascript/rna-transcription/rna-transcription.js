var DnaTranscriber = function() {}

DnaTranscriber.prototype.toRna = function (dna) {

    var rna = {'G': 'C', 'C': 'G', 'T': 'A', 'A': 'U'};
    
    // I'm new to javascript so I'm not sure if there is 
    // an easier way to map over string other than
    // split / join
    return dna.split('')
              .map(function(d){ return rna[d]; })
              .join('');
}

module.exports = DnaTranscriber;