class CreateItems < ActiveRecord::Migration[6.0]
  def change
    create_table :items do |t|
      t.string :label
      t.integer :quantity
      t.boolean :is_already_bought
      t.string :rayon

      t.timestamps
    end
  end
end
