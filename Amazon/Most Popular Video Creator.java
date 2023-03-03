class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Author> map = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            if (map.containsKey(creators[i])) {
                map.get(creators[i]).addVideo(new Video(ids[i], views[i]));
            } else {
                Author author = new Author(creators[i]);
                author.addVideo(new Video(ids[i], views[i]));
                map.put(creators[i], author);
            }
        }

        int maxPopularity = Collections.max(map.values()).popularity;

        List<List<String>> res = new ArrayList<>();
        for (Author a : map.values()) {
            if (a.popularity == maxPopularity) {
                res.add(List.of(
                        a.name,
                        a.getMostPopularVideoId()
                ));
            }
        }
        return res;
    }

    class Author implements Comparable<Author> {
        String name;
        int popularity;
        List<Video> video;

        public Author(String name) {
            this.name = name;
            this.video = new ArrayList<>();
        }

        void addVideo(Video video) {
            this.video.add(video);
            this.popularity += video.view;
        }

        String getMostPopularVideoId() {
            return Collections.max(this.video).id;
        }

        @Override
        public int compareTo(Author o) {
            return this.popularity - o.popularity;
        }
    }

    class Video implements Comparable<Video> {
        String id;
        int view;

        public Video(String id, int view) {
            this.id = id;
            this.view = view;
        }

        @Override
        public int compareTo(Video v2) {
            return this.view - v2.view == 0
                    ? v2.id.compareTo(this.id)
                    : this.view - v2.view;
        }
    }
}