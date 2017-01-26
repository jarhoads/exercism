var Words = function() {

    this.count = function(phrase){
        
        var counts = {};

        var count = function(e){ (counts.hasOwnProperty(e)) ? counts[e] += 1 : counts[e] = 1; };

        phrase.toLowerCase()
              .trim()
              .replace(/\s+/g,' ')
              .split(' ')
              .forEach(count);

        return counts;
    };
};

module.exports = Words;