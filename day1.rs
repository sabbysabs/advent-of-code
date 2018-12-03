use std::io::BufReader;
use std::io::BufRead;
use std::fs::File;

fn main() {
  let f = File::open("input.txt").unwrap();
  let file = BufReader::new(&f);
  let mut v: Vec<String> = Vec::new();
  for line in file.lines() {
    let l = line.unwrap();
    v.push(l.to_string());
  }

  let mut fvalue: i32 = 0;
  for row in v {
    let op: String = row.chars().take(1).collect();
    let value: String = row.chars().skip(1).take(row.len()-1).collect();
    let ivalue = value.parse::<i32>().unwrap();
    if op == "+" {
      fvalue = fvalue + ivalue;
    } else if op == "-" {
      fvalue = fvalue - ivalue;
    }
  }
  println!("final value: {}", fvalue);
}
