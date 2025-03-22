[![Run on Replit](https://replit.com/badge/github/NikosDiakonis/v60-recipe-generator)](https://replit.com/@Nikdiak/v60-recipe-generator)


# ☕ V60 Recipe Generator

A Java-based command line tool that helps you generate personalized brewing recipes for V60 pour-over coffee.  
Select your coffee **process**, **roast level**, and either the **coffee dose** or **total brew water** – and the program does the rest!

---

## 🖼️ Preview

```
================= ☕ Coffee Recipe ☕ =================
• Coffee Dose          : 18.00g
• Water Temperature    : 95°C
• Final Beverage Yield : 260.10ml

---------  💧  Pouring Guide  💧  ------------
• Bloom              : 60.00g  → stop at 0:30
• First pour         : 160.00g → stop at 1:00
• Second pour        : 240.00g → stop at 1:30
• Final pour         : 300.00g → stop at 2:30 - 2:45
---------------------------------------------

💡 If your coffee has a lot of fines,
   skip the second pour and go straight to final.
======================================================
```

---

## 📋 Features

- 🔢 Process & roast level selection
- ⚖️ Choose between coffee dose or total water input
- 🌡️ Auto-adjusted water temperature based on bean profile
- 🧪 Custom brew ratios depending on the process
- 🕰️ Dynamic pour guide with bloom and multiple pour steps
- ☕ Estimated **Final Beverage Yield**
- 💡 Tips based on coffee grind size (e.g., fines)

---

## 🛠️ Technologies

- Java 17  
- Command Line Interface (CLI)  
- Object-Oriented Design

---

## 🚀 How to Run

Clone the repository:

```bash
git clone https://github.com/NikosDiakonis/v60-recipe-generator.git
cd v60-recipe-generator
```

Compile and run with any Java IDE or terminal:

```bash
javac src/*.java
java -cp src Main
```

📚 **Recommended IDE:** IntelliJ IDEA

🧠 **Inspiration:**  
Based on the pour-over method of mister Sotiris Diamantopoulos, tailored and customized to be beginner-friendly yet flexible.

Feel free to ⭐ the repo if you liked it!

[![Run on Replit](https://replit.com/badge/github/NikosDiakonis/v60-recipe-generator)](https://replit.com/@Nikdiak/v60-recipe-generator)


