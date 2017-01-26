var Gigasecond = function(date) {

    // not sure if this is the best way to do it but it's what I came up with
    var gigasecond = date.setSeconds(date.getSeconds() + Math.pow(10,9));

    this.date = function(){ return new Date(gigasecond); };
};

module.exports = Gigasecond;