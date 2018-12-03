enum Operation {
        ADD("+"), SUBTRACT("-");

        private final String sign;

        private Operation(final String sign) {
            this.sign = sign;
        }

        public String getSign() {
            return sign;
        }

        public static Operation getOperation(final String sign) {
            if (ADD.getSign().equals(sign)) {
                return ADD;
            }
            if (SUBTRACT.getSign().equals(sign)) {
                return SUBTRACT;
            }
            return null;
        }
    }

    public static void main(final String[] args) throws Exception {
        final File file = new File("/Users/as013609/Desktop/input.txt");

        final BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        final List<String> entries = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            entries.add(st);
        }
        int fvalue = 0;
        for (final String entry : entries) {
            // first need to get the operation
            final Operation operation = Operation.getOperation(entry.substring(0, 1));
            final int value = Integer.parseInt(entry.substring(1));
            switch (operation) {
            case ADD:
                fvalue += value;
                break;
            case SUBTRACT:
                fvalue -= value;
                break;
            default:
                break;
            }
        }
        System.out.println("First Challenge: " + fvalue);

        boolean dupFound = false;
        int dupValue = 0;
        fvalue = 0;
        final List<Integer> results = new ArrayList<>();
        results.add(0);
        while (dupFound == false) {
            for (final String entry : entries) {
                // first need to get the operation
                final Operation operation = Operation.getOperation(entry.substring(0, 1));
                final int value = Integer.parseInt(entry.substring(1));
                switch (operation) {
                case ADD:
                    fvalue += value;
                    break;
                case SUBTRACT:
                    fvalue -= value;
                    break;
                default:
                    break;
                }
                dupFound = results.contains(fvalue);
                if (dupFound) {
                    dupValue = fvalue;
                    dupFound = true;
                    break;
                } else {
                    results.add(fvalue);
                }
            }
        }
        System.out.println("Second challenge: " + dupValue);
    }
