public class Sum implements Expression {
    Expression augend;

    Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to, Bank bank) {
        int amount = augend.reduce(to, bank).amount + addend.reduce(to, bank).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this,addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times((multiplier)),addend.times(multiplier));
    }
}
