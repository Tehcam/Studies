class CreateMarques < ActiveRecord::Migration[6.0]
  def change
    create_table :marques do |t|
      t.string :nom

      t.timestamps
    end
  end
end
