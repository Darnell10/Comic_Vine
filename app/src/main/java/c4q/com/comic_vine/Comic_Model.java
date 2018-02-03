package c4q.com.comic_vine;

import java.util.List;

/**
 * Created by D on 1/27/18.
 */

public class Comic_Model {


    private List<Results> results;
    private int status_code;
    private int number_of_total_results;
    private int number_of_page_results;
    private int offset;
    private int limit;
    private String error;

    public Comic_Model(String comic_image, String comic_name, String publisher_name, String resource_type, String detail) {
    }


    public List<Results> getResults() {
        return results;
    }

    public int getStatus_code() {
        return status_code;
    }

    public int getNumber_of_total_results() {
        return number_of_total_results;
    }

    public int getNumber_of_page_results() {
        return number_of_page_results;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public String getError() {
        return error;
    }

    public static class Results {
        private String resource_type;
        private String start_year;
        private String site_detail_url;
        private Publisher publisher;
        private String name;
        private Last_episode last_episode;
        private Image image;
        private int id;
        private First_episode first_episode;
        private String description;
        private String deck;
        private String date_last_updated;
        private String date_added;
        private int count_of_episodes;
        private String api_detail_url;

        public String getResource_type() {
            return resource_type;
        }

        public String getStart_year() {
            return start_year;
        }

        public String getSite_detail_url() {
            return site_detail_url;
        }

        public Publisher getPublisher() {
            return publisher;
        }

        public String getName() {
            return name;
        }

        public Last_episode getLast_episode() {
            return last_episode;
        }

        public Image getImage() {
            return image;
        }

        public int getId() {
            return id;
        }

        public First_episode getFirst_episode() {
            return first_episode;
        }

        public String getDescription() {
            return description;
        }

        public String getDeck() {
            return deck;
        }

        public String getDate_last_updated() {
            return date_last_updated;
        }

        public String getDate_added() {
            return date_added;
        }

        public int getCount_of_episodes() {
            return count_of_episodes;
        }

        public String getApi_detail_url() {
            return api_detail_url;
        }
    }

    public static class Publisher {
        private String name;
        private int id;
        private String api_detail_url;

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getApi_detail_url() {
            return api_detail_url;
        }
    }

    public static class Last_episode {
        private String episode_number;
        private String name;
        private int id;
        private String api_detail_url;

        public String getEpisode_number() {
            return episode_number;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getApi_detail_url() {
            return api_detail_url;
        }
    }

    public static class Image {
        private String image_tags;
        private String original_url;
        private String tiny_url;
        private String thumb_url;
        private String super_url;
        private String small_url;
        private String screen_large_url;
        private String screen_url;
        private String medium_url;
        private String icon_url;

        public String getImage_tags() {
            return image_tags;
        }

        public String getOriginal_url() {
            return original_url;
        }

        public String getTiny_url() {
            return tiny_url;
        }

        public String getThumb_url() {
            return thumb_url;
        }

        public String getSuper_url() {
            return super_url;
        }

        public String getSmall_url() {
            return small_url;
        }

        public String getScreen_large_url() {
            return screen_large_url;
        }

        public String getScreen_url() {
            return screen_url;
        }

        public String getMedium_url() {
            return medium_url;
        }

        public String getIcon_url() {
            return icon_url;
        }
    }



    public static class First_episode {
        private String episode_number;
        private String name;
        private int id;
        private String api_detail_url;

        public String getEpisode_number() {
            return episode_number;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getApi_detail_url() {
            return api_detail_url;
        }
    }
}
