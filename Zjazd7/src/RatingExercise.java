import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatingExercise {

    public class User{
        RatingExercise ratingExercise;
        Rating rating;

        public User(String name, int i, RatingExercise ratingExercise) {
            this.ratingExercise = ratingExercise;
            this.rating= ratingExercise.new Rating();
        }

        public Rating getRating() {
            return rating;
        }

        public User accumulate(Rating rating) {
            this.getRating().accumulate(rating);
            return this;
        }

        public User getReviewAverage() {
            this.getRating().computeThisReviewAverage();
            return this;
        }

        // constructor, getters and setters
    }

    public class Review {

        private int points;
        private String review;

        public Review(int i, String s) {
            this.points = i;
            this.review = s;
        }

        public int getPoints() {
            return points;
        }

        // constructor, getters and setters
    }

    public class Rating {

        double points;

        List<Review> reviews = new ArrayList<>();

        public void add(Review review) {
            reviews.add(review);
            computeRating();
        }

        public List<Review> getReviews() {
            return reviews;
        }

        private double computeRating() {
            double totalPoints =
                    reviews.stream().map(Review::getPoints).reduce(0, Integer::sum);
            this.points = totalPoints / reviews.size();
            return this.points;
        }

        public double computeReviewAverage(Rating rating) {
            Integer sum = rating.getReviews().stream().map(review -> review.getPoints()).reduce(0, Integer::sum);
            double count = (double) rating.getReviews().stream().count();

            return sum/count;
        }

        public double computeThisReviewAverage() {
            return computeReviewAverage(this);
        }

        public void accumulate(Rating r) {
            this.reviews.addAll(r.reviews);
        }

    }

    public static void main(String[] args) {
        RatingExercise ratingExercise = new RatingExercise();
        RatingExercise.User john = ratingExercise.new User("John", 30, ratingExercise);
        john.getRating().add(ratingExercise.new Review(5, ""));
        john.getRating().add(ratingExercise.new Review(3, "not bad"));
        User julie = ratingExercise.new User("Julie", 35, ratingExercise);
        julie.getRating().add(ratingExercise.new Review(4, "great!"));
        julie.getRating().add(ratingExercise.new Review(2, "terrible experience"));
        julie.getRating().add(ratingExercise.new Review(4, ""));
        List<User> users = Arrays.asList(john, julie);


        //Create dummy user which collects all the reviews of other users
        User averageRatingUser = users.stream()
                .reduce(ratingExercise.new User("acc", 1, ratingExercise),
                        (accumulationUser, u) -> accumulationUser.accumulate(u.getRating()),
                        (partial1, partial2) -> partial1.accumulate(partial2.getRating()));

        //Get average of the reviews
        System.out.println(averageRatingUser.rating.computeThisReviewAverage());
    }
}
