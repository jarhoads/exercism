# Notes about my solution
I added the following tests to make sure the client doesn't have access to the internal roster and grade list:

```csharp
    [Ignore("Remove to run test")]
    [Test]
    public void Should_not_have_access_to_roster()
    {
        school.Roster[3] = new List<string> { "Student" };
         Assert.That(school.Grade(3), Is.EqualTo(new List<string>()));
    }

    [Ignore("Remove to run test")]
    [Test]
    public void Should_not_access_grade_list()
    {
        school.Add("Blair", 2);
        school.Add("James", 2);
        school.Add("Paul", 2);
        var students = school.Grade(2);
        students.Add("Student");
        var expected = new List<string> { "Blair", "James", "Paul" };
        Assert.That(school.Roster[2], Is.EqualTo(expected));
    }
```

# Grade School

Write a small archiving program that stores students' names along with the grade that they are in.

In the end, you should be able to:

- Add a student's name to the roster for a grade
  - "Add Jim to grade 2."
  - "OK."
- Get a list of all students enrolled in a grade
  - "Which students are in grade 2?"
  - "We've only got Jim just now."
- Get a sorted list of all students in all grades.  Grades should sort
  as 1, 2, 3, etc., and students within a grade should be sorted
  alphabetically by name.
  - "Who all is enrolled in school right now?"
  - "Grade 1: Anna, Barb, and Charlie. Grade 2: Alex, Peter, and Zoe.
    Grade 3…"

Note that all our students only have one name.  (It's a small town, what
do you want?)


## For bonus points

Did you get the tests passing and the code clean? If you want to, these
are some additional things you could try:

- If you're working in a language with mutable data structures and your
  implementation allows outside code to mutate the school's internal DB
  directly, see if you can prevent this. Feel free to introduce additional
  tests.

Then please share your thoughts in a comment on the submission. Did this
experiment make the code better? Worse? Did you learn anything from it?

### Submitting Exercises

Note that, when trying to submit an exercise, make sure you're exercise file you're submitting is in the `exercism/csharp/<exerciseName>` directory.

For example, if you're submitting `bob.cs` for the Bob exercise, the submit command would be something like `exercism submit <path_to_exercism_dir>/csharp/bob/bob.cs`.

## Source

A pairing session with Phil Battos at gSchool [http://gschool.it](http://gschool.it)
