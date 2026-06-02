error id: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/model/Product.java
file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/model/Product.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[36,1]

error in qdox parser
file content:
```java
offset: 1334
uri: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/model/Product.java
text:
```scala
// Product.java
// Ta klasa reprezentuje pojedynczy produkt w sklepie.
// Jest IMMUTABLE — czyli po stworzeniu obiektu nie można go zmienić.
// To jest bardzo dobre dla promocji, bo nie psujemy oryginalnych danych.

package com.javamarkt.model;

public final class Product {

    private final String code;          // unikalny kod produktu
    private final String name;          // nazwa produktu
    private final double price;         // cena podstawowa
    private final double discountPrice; // cena po rabacie (domyślnie = price)

    // Konstruktor podstawowy — produkt bez rabatu
    public Product(String code, String name, double price) {
        this(code, name, price, price);
    }

    // Konstruktor pełny — używany gdy promocja zmienia cenę
    public Product(String code, String name, double price, double discountPrice) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    // Gettery — tylko do odczytu
    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getDiscountPrice() { return discountPrice; }

    // Tworzy NOWY produkt z inną ceną po rabacie
    // To jest kluczowe dla immutability
 @@   public Product withDiscountPrice(double newPrice) {

```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1575)
```
#### Short summary: 

QDox parse error in file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/model/Product.java