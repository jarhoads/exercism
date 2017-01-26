var Year = function(year) {
    var _year = year;

    // I'm not sure whether or not people prefer this
    // or if it's better to add it as 
    // Year.prototype.isLeap
    this.isLeap = function() {
        return (_year % 4 == 0) && ((_year % 100 != 0) || (_year % 400 == 0))
    };
};

module.exports = Year;