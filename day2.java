public static void main(final String[] args) throws Exception {
        final File file = new File("/Users/as013609/Desktop/input2.txt");

        final BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        final List<String> entries = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            entries.add(st);
        }

        int checksum = 0;
        int twoCount = 0;
        int threeCount = 0;
        for (final String entry : entries) {
            final int size = entry.length();
            final Map<String, Integer> countByLetter = new HashMap<>(size);
            for (int i = 0; i < size; i++) {
                final int tempSize = i + 1;
                String letter;
                if (tempSize < size) {
                    letter = entry.substring(i, tempSize);
                } else {
                    letter = entry.substring(i);
                }
                Integer count = countByLetter.get(letter);
                if (count == null) {
                    count = 0;
                }
                countByLetter.put(letter, ++count);
            }
            boolean twoAlreadyAccounted = false;
            boolean threeAlreadyAccounted = false;
            for (final Map.Entry<String, Integer> ent : countByLetter.entrySet()) {
                if (ent.getValue() == 2 && !twoAlreadyAccounted) {
                    twoCount++;
                    twoAlreadyAccounted = true;
                    continue;
                }
                if (ent.getValue() == 3 && !threeAlreadyAccounted) {
                    threeCount++;
                    threeAlreadyAccounted = true;
                    continue;
                }
                if (twoAlreadyAccounted && threeAlreadyAccounted) {
                    break;
                }
            }
        }
        checksum = twoCount * threeCount;
        System.out.println("Day Two Challenge One: " + checksum);

        String first = "";
        String second = "";
        for (int x = 0; x < entries.size(); x++) {
            first = entries.get(x);
            final List<String> firstLetters = new ArrayList<>();
            boolean found = false;
            for (int z = 0; z < first.length(); z++) {
                final int tempSize = z + 1;
                if (tempSize < first.length()) {
                    firstLetters.add(first.substring(z, tempSize));
                } else {
                    firstLetters.add(first.substring(z));
                }
            }
            for (int y = x + 1; y < entries.size(); y++) {
                second = entries.get(y);
                int offCount = 0;
                for (int z = 0; z < second.length(); z++) {
                    String tempStr;
                    final int tempSize = z + 1;
                    if (tempSize < second.length()) {
                        tempStr = second.substring(z, tempSize);
                    } else {
                        tempStr = second.substring(z);
                    }
                    if (!tempStr.equals(firstLetters.get(z))) {
                        offCount++;
                    }
                }
                if (offCount <= 1) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        System.out.println("Day Two Challenge Two:\nfirst:\t" + first + "\nsecond:\t" + second);
    }
