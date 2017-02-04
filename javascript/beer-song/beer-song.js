var BeerSong = function(){

    var bottleOrBottles = function(n){
        return (n > 1) ?  ' bottles' : ' bottle';
    };

    this.verse = function(bottles){
        if(bottles === 0){
            return 'No more bottles of beer on the wall, no more bottles of beer.\n' +
                   'Go to the store and buy some more, 99 bottles of beer on the wall.\n';
        }

        if(bottles == 1){
            return  '1 bottle of beer on the wall, 1 bottle of beer.\n' +
                    'Take it down and pass it around, no more bottles of beer on the wall.\n';
        }

         return bottles + ' bottles of beer on the wall, ' +
                bottles + ' bottles of beer.\nTake one down and pass it around, ' +
                (bottles - 1) + bottleOrBottles(bottles - 1) +
                ' of beer on the wall.\n';

    };

    this.sing = function(begin, end){
        // set default value
        // I'm sure there is a better way
        // I just don't know what it is
        end = typeof end !== 'undefined' ? end : 0;

        return (begin === end) ? this.verse(end) : this.verse(begin) + '\n' + this.sing(begin - 1, end);
    };

};

module.exports = BeerSong;